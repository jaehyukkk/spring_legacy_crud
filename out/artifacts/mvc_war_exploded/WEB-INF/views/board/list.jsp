<%--
  Created by IntelliJ IDEA.
  User: jangjaehyeog
  Date: 2022/06/23
  Time: 4:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>


<style>
.list-table{
    width: 1000px;
    margin: 100px auto 0;
}
.list-create-btn{
    width: 1000px;
    margin:0 auto;
    display: flex;
    justify-content: flex-end;
}
</style>

<article class="board-list">
    <div>
        <div class="list-table">
            <h2>SPRING BOARD</h2>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col" width="70%">제목</th>
                    <th scope="col">작성자</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="boardDto">
                    <tr>
                        <th scope="row">${boardDto.seq}</th>
                        <td><a href="/board/${boardDto.seq}/detail">${boardDto.title}</a></td>
                        <td>${boardDto.writer}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <form id="actionForm" action ="/board" method="get">
            <input type="hidden" name="pageNum" value="${pageMaker.criteria.pageNum}" />
            <input type="hidden" name="amount" value="${pageMaker.criteria.amount}" />
        </form>

        <div class="pull-right">
            <ul class="pagination">
                <c:if test="${pageMaker.prev}">
                    <li class="paginate_button previous">
                        <a href="${pageMaker.startPage -1}">Previous</a>
                    </li>
                </c:if>

                <c:forEach
                    var="num"
                    begin="${pageMaker.startPage}"
                    end="${pageMaker.endPage}">
                    <li class="paginate_button ${pageMaker.criteria.pageNum == num ? "active" :""}">
                        <a href="${num }">${num }</a>
                    </li>
                </c:forEach>

                <c:if test="${pageMaker.next}">
                    <li class="paginate_button next">
                        <a href="${pageMaker.endPage +1 }">Next</a>
                    </li>
                </c:if>
            </ul>
        </div>

        <div class="list-create-btn">
            <a href="<c:url value="/board/create"/>">
                <button class="btn btn-primary">글쓰기</button>
            </a>
        </div>

    </div>
</article>

<script>
    $(document).ready(function () {
        let actionForm = $("#actionForm");

        $(".paginate_button a").on("click", function (e) {
            e.preventDefault();
            console.log("click");
            actionForm.find("input[name='pageNum']").val($(this).attr("href"));
            actionForm.submit();
        });
    });
</script>
</body>
</html>
