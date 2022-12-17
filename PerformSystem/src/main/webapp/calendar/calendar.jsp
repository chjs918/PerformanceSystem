<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Calendar"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

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
    <H6><a href="<c:url value='/calendar/calendar' />">자세한 캘린더</a></H6>
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
               if (confirm('일정을 삭제하시겠습니까?')) {
                 arg.event.remove()
               }
             },
         
             editable: true,
             displayEventTime: false,
             dayMaxEvents: true, // allow "more" link when too many events
             events: [
                { 
                 title: '해리 스타일스 첫 내한공연（HARRY STYLES LOVE ON TOUR 2023 - Live in Seoul', 
                 start: '2023-03-20' 
              },
                { 
                 title: '[서울] 2022년 ‘Dream 55’ 나훈아 앵콜 콘서트', 
                 start: '2022-12-17',
                 end: '2022-12-19' 
              }, 
               <c:forEach var="cal" items="${calendarList}">
                {
                   title : '${cal.calendarTitle}', 
                   start : '${cal.calendarStart}',
                   end : '${cal.calendarEnd}',
                   color : '#' + Math.round(Math.random() * 0xffffff).toString(16)
                  },
            </c:forEach> 
          
             ]
  
           });   
           
           calendar.render();
         });


   </script>
</body>
</html>