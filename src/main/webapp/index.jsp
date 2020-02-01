
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Tienda Web</title>

        <!-- ================= Favicon ================== -->
        <!-- Standard -->
        <link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
        <!-- Retina iPad Touch Icon-->
        <link rel="apple-touch-icon" sizes="144x144" href="http://placehold.it/144.png/000/fff">
        <!-- Retina iPhone Touch Icon-->
        <link rel="apple-touch-icon" sizes="114x114" href="http://placehold.it/114.png/000/fff">
        <!-- Standard iPad Touch Icon-->
        <link rel="apple-touch-icon" sizes="72x72" href="http://placehold.it/72.png/000/fff">
        <!-- Standard iPhone Touch Icon-->
        <link rel="apple-touch-icon" sizes="57x57" href="http://placehold.it/57.png/000/fff">

        <!-- Styles -->
        <link href="assets/css/lib/weather-icons.css" rel="stylesheet" />
        <link href="assets/css/lib/owl.carousel.min.css" rel="stylesheet" />
        <link href="assets/css/lib/owl.theme.default.min.css" rel="stylesheet" />
        <link href="assets/css/lib/font-awesome.min.css" rel="stylesheet">
        <link href="assets/css/lib/themify-icons.css" rel="stylesheet">
        <link href="assets/css/lib/menubar/sidebar.css" rel="stylesheet">
        <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">

        <link href="assets/css/lib/helper.css" rel="stylesheet">
        <link href="assets/css/style.css" rel="stylesheet">

    </head>
    <body>
        <jsp:include page="pages/layout/sidebar.jsp"></jsp:include>
        <jsp:include page="pages/layout/header.jsp">
            <jsp:param name="name" value="Alex Ferreras" />
        </jsp:include>


        <div class="content-wrap">
            <div class="main">
                <div class="container-fluid">
                    <%
                        String pages = "dashboard";

                        if (request.getParameter("page") != null) {
                            pages = request.getParameter("page");
                        }

                        pages = "pages/" + pages + ".jsp";
                    %>
                    <jsp:include page="<%=pages%>"></jsp:include>

                </div>
            </div>
        </div>

        <!-- jquery vendor -->
        <script src="assets/js/lib/jquery.min.js"></script>
        
        <script src="assets/js/lib/jquery.nanoscroller.min.js"></script>
        <!-- nano scroller -->
        <script src="assets/js/lib/menubar/sidebar.js"></script>
        <script src="assets/js/lib/preloader/pace.min.js"></script>
        <!-- sidebar -->
        <script src="assets/js/lib/bootstrap.min.js"></script>

        <!-- bootstrap -->

        <script src="assets/js/lib/circle-progress/circle-progress.min.js"></script>
        <script src="assets/js/lib/circle-progress/circle-progress-init.js"></script>

        <script src="assets/js/lib/morris-chart/raphael-min.js"></script>
        <script src="assets/js/lib/morris-chart/morris.js"></script>
        <script src="assets/js/lib/morris-chart/morris-init.js"></script>

        <script src="assets/js/lib/owl-carousel/owl.carousel.min.js"></script>
        <script src="assets/js/lib/owl-carousel/owl.carousel-init.js"></script>
        <!--<script src="assets/js/scripts.js"></script>-->
        <!-- scripit init-->
    </body>

</html>

