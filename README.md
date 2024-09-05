### Todo 웹 프로그램
#### 목록화면 (List) - GET
- 목록 화면은 GET 방식으로 조회하는 화면
- 등록, 수정, 삭제 후에도 결과를 확인할 수 있는 화면
#### 등록 화면 (Register) - GET
- GET 이동하기 때문에 등록 화면 `register.jsp` 페이지 이동
#### 등록 화면 (Register) - POST
- 입력 데이터들을 POST 방식으로 서버 전송 => 별도의 Controller가 추가되야 한다.
- 처리한 후 Redirect 방식ㅇ으로 다시 목록 페이지로 이동한다.
- 목록 페이지로 돌ㅇ아간 후 새롭게 등록된 글이 반영되어 목록을 보여준다
#### 조회 화면 (Read) - GET
- GET 방식으로 동작 설계한다.
- 목록 화면에서 특정 Todo 글 번호를 누르면 동작하도록 설계한다.
#### 수정/삭제 (Remove/Delete) - GET
- GET 방식 설계한다. (해당 화면으로 이동)
- 수정/삭제 화면에서는 POST 방식으로 수정, 삭제 진행할 수 있도록 버튼을 추가한다.
#### 수정 화면 (Modify) - POST
- 목록 화면 (List)로 Redirect
#### 삭제 화면 (Delete) - POST
- 목록 화면 (List)로 Redirect
