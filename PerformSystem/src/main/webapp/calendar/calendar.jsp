<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Performance"%>

<html>
<head>
<title>Calendar</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.css">

<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>

</head>
<body>
	<H2 align='center'>Performance Calendar</H2>
	<div id='calendar'></div>
	<script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function() {
    	    var calendarEl = document.getElementById('calendar');
    	    var calendar = new FullCalendar.Calendar(calendarEl, {
    	      headerToolbar: {
    	        left: 'prev,next today',
    	        center: 'title',
    	        right: 'dayGridMonth,timeGridWeek,timeGridDay'
    	        
    	      },
    	      initialDate:  new Date(),
    	      navLinks: true, // can click day/week names to navigate views
    	      selectable: true,
    	      selectMirror: true,
    	      select: function(arg) {
    	        var title = prompt('Performance Title:');
    	        if (title) {
    	          calendar.addEvent({
    	            title: title,
    	            start: arg.start,
    	            end: arg.end,
    	            allDay: arg.allDay
    	          })
    	        }
    	        calendar.unselect()
    	      },
    	      eventClick: function(arg) {
    	        if (confirm('Are you sure you want to delete this performance?')) {
    	          arg.event.remove()
    	        }
    	      },
    	  
    	      editable: true,
    	      dayMaxEvents: true, // allow "more" link when too many events
    	      events: [
   <%-- 	    	  <%List<Performance> calendarList = (List<Performance>) request.getAttribute("calendarList");%>
  	            <%if (calendarList != null) {%>
  	            <%for (Performance p : calendarList) {%>
  	            {
  	            	title : '<%=p.getName()%>',
  	                start : '<%=p.getStartDate()%>',
  	                end : '<%=p.getEndDate()%>',
  	                color : '#' + Math.round(Math.random() * 0xffffff).toString(16)
  	             },
  		<%} //calendarList null 상태, 받아오게 수정하기
  	}%>
  	--%>
		  		{ 
					title: '2022 서울그린아트페스티벌', 
					start: '2022-12-07', 
					end: '2022-12-09' 
				},
		  		{ 
					title: '해리 스타일스 첫 내한공연（HARRY STYLES LOVE ON TOUR 2023 - Live in Seoul', 
					start: '2023-03-20' 
				},
		  		{ 
					title: '[서울] 2022년 ‘Dream 55’ 나훈아 앵콜 콘서트', 
					start: '2022-12-17',
					end: '2022-12-19' 
				}, 
		  		{ 
					title: '[성남] 2022 멜로망스 콘서트 〈Festival〉', 
		  			start: '2023-02-11',
		  			end: '2023-02-13' 
		  		},
		  		{ 
		  			title: '2022 CRUSH ON YOU TOUR ［CRUSH HOUR］ - 서울', 
		  			start: '2022-12-23', 
		  			end: '2022-12-26' 
		  		},
		  		{ 
		  			title: '2022 성시경 연말 콘서트', 
		  			start: '2022-12-23', 
		  			end: '2022-12-26' 
		  		},
		  		{ 
		  			title: '자우림 단독 콘서트 ［ MERRY SPOOKY X-MAS ］ - 서울', 
		  			start: '2022-12-09', 
		  			end: '2022-12-13' 
		  		},
    	      ]
  
    	    });	
    	    
    	    calendar.render();
    	  });
	</script>

</body>
</html>