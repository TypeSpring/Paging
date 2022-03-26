import React, { FC } from "react";
import Pagination from "@mui/material/Pagination";

const MyPagination: FC = () => {
  return (
    <>
      <div>페이지네이션</div>

      <Pagination count={10} color="secondary" />
    </>
  );
};
export default MyPagination;
