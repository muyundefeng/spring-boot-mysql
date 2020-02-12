$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8081/getAllUser"
    }).then(function(data) {

            var str = "<table class='tab-list' width='40%' border='1px solid #ccc' cellspacing='0 cellpadding='0'>";
            str = str+"<tr class='list-header'>"+"<td width='5%'>name</td>"+"<td width='5%'>email</td></tr>"
            for (var i = 0, len = data.length; i < len; i++) {
                str += "<tr><td>"+data[i].name+"</td> <td>"+data[i].email + "</td></tr>";
            }
           str = str + "</table>";
           console.log(str);
           document.getElementById("content").innerHTML=str;
    });
});