import React, { FC, useState, useEffect } from "react";
import Pagination from "@mui/material/Pagination";
import { CardProps } from "./InfScroll";
import { request } from "../config/axios";
import MyCard from "../component/MyCard";

const MyPagination: FC = () => {
  const [list, setList] = useState<CardProps[]>([]);
  const [loading, setLoading] = useState<Boolean>(false);
  const [totalPage, setTotalPage] = useState<number>(10);
  const [currentPage, setCurrentPage] = useState<number>(1);

  //클라이언트측에서 서버에게 한 페이지당 몇개의 게시글을 달라고 요청할 지 지정
  //이 프로젝트에서는 지정 안 하고, 서버에서 default로 주는 값 사용함
  // const [postsPerPage, setPostsPerPage] = useState<number>(20);

  useEffect(() => {
    async function fetchData() {
      setLoading(true);
      await request.get(`?page=${currentPage - 1}`).then((res) => {
        setList(res.data.content);
        setLoading(false);

        //데이터를 받아올 때 총 페이지를 받아온다.
        setTotalPage(res.data.totalPages);
      });
    }
    fetchData();
  }, [currentPage]);

  const handlePageChange = (
    event: React.ChangeEvent<unknown>,
    value: number
  ) => {
    console.log(currentPage);
    setCurrentPage(value);
  };
  return (
    <div className="MyPagination">
      <div>
        {list && list.map((item, idx) => <MyCard key={idx} CardData={item} />)}
      </div>
      <Pagination
        page={currentPage}
        onChange={handlePageChange}
        count={totalPage}
        color="secondary"
      />
    </div>
  );
};
export default MyPagination;
