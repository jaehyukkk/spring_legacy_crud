<%--
  Created by IntelliJ IDEA.
  User: jangjaehyeog
  Date: 2022/06/23
  Time: 5:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
    .board-detail{
        display: flex;
        justify-content: center;
        margin-top:100px;
    }
    .detail-btns{
        display: flex;
        justify-content: flex-end;
        margin-top:20px;
    }
    .detail-btns button{
        margin-right: 3px;
    }
    .title{
        margin-top:30px;
        font-size: 18px;
    }
    .description{
        border : 1px solid #dadada;
        height: 300px;
        padding:10px;
    }
    a{
        text-decoration: none;
        color: white;
    }
    .comment{
        margin-top:20px;
    }
    .comment textarea{
        border:1px solid #dadada;
        width: 100%;
    }
</style>

  <article class="board-detail">
      <div>
          <h2>BOARD DETAIL</h2>
          <p class="title"><strong>${board.title}</strong></p>
          <div class="description">${board.description}</div>

          <div class="detail-btns">
              <button class="btn btn-primary"><a href="/board/${board.seq}/update">수정</a></button>
              <button class="btn btn-danger" id="board-delete" data-seq = ${board.seq}>삭제</button>
          </div>

        <c:forEach items="${board.comments}" var="comment">
            <div>${comment.comment_description}</div>
        </c:forEach>

        <div class="comment">
              <p>COMMENT</p>
              <form action="/comment/create" method="post">
                  <textarea name="comment_description" class="comment_description"></textarea>
                  <input type="hidden" name="board_seq" value="${board.seq}"/>
                  <div class="detail-btns" id="comment-btn">
                      <button class="btn btn-primary">등록</button>
                  </div>
              </form>
          </div>

          <div>
              <p>첨부 이미지</p>
              <c:forEach items="${board.files}" var="files">
                  <img src="/board/img/${files.fileSeq}"/>
              </c:forEach>
          </div>

      </div>
  </article>

<script>
    $(function () {
        $('#comment-btn button').on("click", function (e) {
            if ($('.comment_description').val().length == 0) {
                e.preventDefault();
                alert("댓글을 입력해주세요.");
            }
        });
    });

    $("#board-delete").on("click",function(){
        let result = confirm("정말 삭제하시겠습니까?");
        let seq = $(this).data("seq");
        if(result){
            $.ajax({
                url: "/board/delete",
                method: "post",
                data:{seq : seq}
            }).done(function(){
                location.href="/board"
                alert("삭제되었습니다.");
            }).fail(function(error){
                console.log(error);
            })
        }
    })

</script>
</body>
</html>
