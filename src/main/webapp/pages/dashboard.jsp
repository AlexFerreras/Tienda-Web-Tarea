<%-- 
    Document   : Dashboard
    Created on : Jan 20, 2020, 6:58:20 PM
    Author     : ALEX FERRERAS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /# row -->
<section id="main-content">
    <div class="row">
        <div class="col-lg-3">
            <div class="card">
                <div class="stat-widget-two">
                    <div class="stat-content">
                        <div class="stat-text">Cantidad de Productos</div>
                        <div class="stat-digit"> <i class="fa fa-usd"></i>${totalProducts}</div>
                    </div>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success w-85" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-3">
            <div class="card">
                <div class="stat-widget-two">
                    <div class="stat-content">
                        <div class="stat-text">Total Activos en productos + ITBS</div>
                        <div class="stat-digit"> <i class="fa fa-usd"></i>${totalInvestedWithITB}</div>
                    </div>
                    <div class="progress">
                        <div class="progress-bar progress-bar-primary w-75" role="progressbar" aria-valuenow="78" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-3">
            <div class="card">
                <div class="stat-widget-two">
                    <div class="stat-content">
                        <div class="stat-text">Productos vendidos</div>
                        <div class="stat-digit"> <i class="fa fa-usd"></i> 500</div>
                    </div>
                    <div class="progress">
                        <div class="progress-bar progress-bar-warning w-50" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-3">
            <div class="card">
                <div class="stat-widget-two">
                    <div class="stat-content">
                        <div class="stat-text">Productos faltantes</div>
                        <div class="stat-digit"> <i class="fa fa-usd"></i>650</div>
                    </div>
                    <div class="progress">
                        <div class="progress-bar progress-bar-danger w-65" role="progressbar" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <!-- /# card -->
        </div>
        <!-- /# column -->
    </div>
    <!-- /# row -->
    <script>
        

    </script>

    <div class="row">
        <!-- column -->
        <div class="col-lg-8">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Sales Overview</h4>
                    <div id="morris-bar-chart" ></div>
                </div>
            </div>
        </div>
        <!-- column -->
        <div class="col-md-4">
            <div class="card text-center">
                <div class="m-t-10">
                    <p>Customer Feedback</p>
                    <h5>385749</h5>
                </div>
                <div class="widget-card-circle pr m-t-20 m-b-20" id="info-circle-card">
                    <i class="ti-control-shuffle pa"></i>
                </div>
                <ul class="widget-line-list m-b-15">
                    <li class="border-right">92% <br><span class="color-success"><i class="ti-hand-point-up"></i> Positive</span></li>
                    <li>8% <br><span class="color-danger"><i class="ti-hand-point-down"></i>Negative</span></li>
                </ul>
            </div>
        </div>

    </div>

    
      
        
    </div>


</section>

