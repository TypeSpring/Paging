import React, { FC } from "react";
import Card from "@mui/material/Card";
import CardMedia from "@mui/material/CardMedia";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";

const MyCard: FC = () => {
  return (
    <>
      <Card>
        <CardMedia component="img" alt="thumbnail" height="140" image="" />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            title
          </Typography>
          <Typography variant="body2" color="text.secondary">
            body
          </Typography>
        </CardContent>
      </Card>
      ;
    </>
  );
};
export default MyCard;
