<%--
  Created by IntelliJ IDEA.
  User: abiz
  Date: 5/21/2019
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(document).ready(
        $("select").each(function () {
            var dd = $(this);
            $(this).find('option').each(function (i, opt) {
                //alert(i + '-' + opt.value +"-"+ dd.attr("value"));
                if(dd.attr("value") == opt.value){
                    $(opt).attr('selected','selected');
                }
            })
        })
    );
</script>
