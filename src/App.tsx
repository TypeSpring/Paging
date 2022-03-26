import React from "react";
import "./App.css";
import Home from "./page/Home";
import InfScroll from "./page/InfScroll";
import { Route, Routes, BrowserRouter } from "react-router-dom";
import MyPagination from "./page/MyPagination";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/infscroll" element={<InfScroll />} />
        <Route path="/pagination" element={<MyPagination />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
