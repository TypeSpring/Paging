import React, { FC } from "react";
import Card from "@mui/material/Card";
import CardMedia from "@mui/material/CardMedia";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import { CardProps } from "../page/InfScroll";

export default function MyCard({ CardData }: { CardData: CardProps }) {
  const { thumbnail, author, contents, title } = CardData;
  return (
    <>
      <Card sx={{ width: "200px" }} className="MyCard">
        <CardMedia
          component="img"
          alt="thumbnail"
          height="140"
          image={thumbnail}
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            title : {title}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            author : {author}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            content : {contents}
          </Typography>
        </CardContent>
      </Card>
    </>
  );
}
