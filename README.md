<h3>기본 jsp 업로드 방법</h3>

1. 기본적으로 html(jsp)파일은 /views/폴더 안에 넣는다. 
2. js, css는 별도로 resources 파일 안에 넣는다

********************
.jsp 파일 폴더명들
/webapp/
(css관련)/webapp/resources/css/(안에 해당 폴더 명들 각각 적어서)/
(js관련)/webapp/resources/js/(안에 해당 폴더 명들 각각 적어서)/

(마이페이지)/webapp/views/mypage/
(기업리뷰관련)/webapp/views/companyReview/
(게시판)/webapp/views/board/
(고객센터)/webapp/views/notice/
(로그인/회원가입)/webapp/views/account/

**************************

3. jsp파일 기본틀 복사해서 css추가 파트에는 각 파일의 css 링크 넣고, 맨밑에 js추가에는 top.js 밑에 추가하기
가운데 <!-- 내용 넣기 --> 파트에 각 헤더 푸터를 제외한 html 파일 내용 그대로 넣어주시면됩니다.


4. 서블릿 만들기(서버를 만들고 링크를 /account/list 처럼 .jsp를 제외하고 폴더명처럼 연결짓습니다)
 	- java Resources 안에 com.algo.mvc 클릭
	- servlet 만들기
		-> Java package : com.algo.mvc.(폴더명).controller
		-> ClassName : 폴더명jsp파일명Servlet    (예시: AccountListServlet)
	- Next 누르고,
		-> Name 은 맨앞에 단어 소문자, Servlet 삭제 (예시 : accountList)
		-> URL mappings는 폴더명과 jsp파일명을 /로 나누고 맨앞에 문자 소문자 (예시 : account/list)
	- 저는 doGet, doPost 다 받았습니다. Finish 누르기

5. 코드내에 지울것들 지우고, doGet, doPost위에 @Override 작성.
doGet에 

request.getRequestDispatcher("/views/companyReview/companyDetail.jsp").forward(request, response);

넣기. 링크안에는 해당 연결해야할 파일 링크 그대로 적어주세요!
