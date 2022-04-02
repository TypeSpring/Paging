import React, { FC, useState, useRef, useEffect, useCallback } from "react";
import { useInView } from "react-intersection-observer";
import { request } from "../config/axios";
import MyCard from "../component/MyCard";

export interface CardProps {
  id: number;
  title: string;
  thumbnail: string;
  author: string;
  contents: string;
}

const InfScroll: FC = () => {
  const [list, setList] = useState<CardProps[]>([]);
  const [isMount, setIsMount] = useState<Boolean>(true);
  const [page, setPage] = useState<number>(0);
  const [isLast, setIsLast] = useState<Boolean>(false);
  const [loading, setLoading] = useState<Boolean>(false);
  const [ref, inView] = useInView();
  const observerRef = useRef<IntersectionObserver>();

  // 서버에서 아이템을 가지고 오는 함수
  const getItems = useCallback(async () => {
    setLoading(true);
    console.log(`isMount: ${isMount}`);
    if ((!isLast && inView) || isMount) {
      await request
        .get(`/v2/posts?page=${page}`)
        .then((res) => {
          console.log(`${page}요청함`);
          setList((prev) => prev.concat(res.data.content));
          setIsLast(res.data.last);
        })
        .catch((err) => console.log(err));
      setLoading(false);
      setPage((prev) => prev + 1);
    }
  }, [inView]);

  useEffect(() => {
    setIsMount(false);
  }, []);

  // `getItems` 가 바뀔 때 마다 함수 실행
  useEffect(() => {
    getItems();
    console.log(inView);
  }, [getItems]);

  return (
    <div>
      {list.map((item, idx) => (
        <React.Fragment key={idx}>
          {list.length - 1 === idx ? (
            <div ref={ref}>
              <MyCard CardData={item} />
            </div>
          ) : (
            <div className="list-item">
              <MyCard CardData={item} />
            </div>
          )}
        </React.Fragment>
      ))}
    </div>
  );
};
export default InfScroll;
