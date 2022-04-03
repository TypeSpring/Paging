## Paging

### ✨Pagination

- 클라이언트측에서 서버에게 한 페이지당 몇개의 게시글을 달라고 요청할 지 지정
  (이 프로젝트에서는 지정 안 하고, 서버에서 default로 주는 값 사용함)

- 이 프로젝트에서는 [mui pagination](https://mui.com/components/pagination/)를 사용해서 구현함
  `page` : 현재 보여지는 page
  `onChange` : 페이지가 바뀔 때마다 실행됨
  `count` : 총 몇 페이지까지 있는지

- currentPage가 바뀔 때마다 서버로 list를 받아온다. 이 때, 보여지는 페이지는 `1`부터이나 서버에 요청할 떄는 `0`부터 요청해야해서 다음과 같이 요청함
  request.get(\`/v1/posts?page=${currentPage - 1}\`)
