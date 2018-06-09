<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<form method="post" action="setting.do">
		예매 팀 : <input type="text" name="team"/> <br>
		경기 선택(몇번째 경기 숫자만) : <input type="text" name="select_game" /> <br>
		좌석 선택(전체 포함 몇번째 숫자만) : <input type="text" name="select_seat" /> <br>
		티켓 예매 수 : <input type="text" name="count" /> <br>
		예매 시작 시간( ex) 23.00  ) : <input type="text" name="time" /> <br>
		<select name="state"> <br>
			<option value="test">테스트</option>
			<option value="real">실제구매</option>
		</select>
		<input type="submit" value="서브밋" />
	</form>
<script>
	$(document).ready(function(){
		init();
		
		
		function init(){
			eventHandler();
			
			function eventHandler(){
				$('#submit').click(function(){
					var search = $('#search').val();
					$.ajax({
				        url:"search.do",
				        type:'GET',
				        contentType:'application/json; charset=UTF-8',
				        data: {search : search},
				        success:function(data){
							renderList(data);
				        },
				        error:function(data){
				        	console.log(data)
				        }
				    });
				})
			}
		}
	})
	
	function renderList(jsonList){
		var $ul = document.getElementById('list');
		$ul.innerHTML = '';
		for(var i=0; i<jsonList.length; i++) {
			var li = document.createElement('li');
			li.innerHTML = jsonList[i].title + ' / size : ' + jsonList[i].size;
			li.setAttribute('data-id',jsonList[i].downId);
			li.setAttribute('data-category',jsonList[i].category);
			li.addEventListener('click',function(){
				var downId = this.getAttribute('data-id');
				var title = this.innerHTML.replace(/\/.*/,"").trim()+".torrent";
				var category = this.getAttribute('data-category');
				$.ajax({
			        url:"download.do",
			        type:'GET',
			        data: {
			        	downId : downId,
			        	title : title,
			        	category : category
		        	},
			        success:function(data){
						alert('성공');
			        },
			        error:function(data){
			        	console.log(data)
			        }
			    });
			});
			
			$ul.appendChild(li);
		}
	}
</script>
</body>
</html>