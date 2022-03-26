import React, { FC } from "react";
import { Link } from "react-router-dom";

const Home: FC = () => {
  return (
    <>
      <Link to="/infscroll">무한스크롤</Link>
      <Link to="/pagination">페이지네이션</Link>
    </>
  );
};
export default Home;
