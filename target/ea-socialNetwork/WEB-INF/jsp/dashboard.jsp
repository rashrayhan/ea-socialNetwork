<jsp:include page="/WEB-INF/jsp/includes/dashboard-header.jsp"></jsp:include>

    
  <main class="pt-5 mx-lg-5">
        <div class="container-fluid mt-5">
            <div class="d-flex justify-content-center">
                <div class="card mb-5 wow fadeIn col-8">
                    <div class="card-body d-sm-flex text-center">
                        <form class="form col-12 p-5" action="" method="post" enctype="multipart/form-data">
                            <textarea class="form-control mr-sm-2 p-2" rows="5" autofocus name="advertisement" placeholder="Enter advertisement text"></textarea>

                            <label class="btn purple-gradient btn-sm"> <i class="fa fa-image"></i><input type="file" class="uploadFile" name="picture[]" multiple accept="image/*">
                            </label>

                            <label class="btn aqua-gradient btn-sm"> <i class="fa fa-video"></i><input type="file" class="uploadFile" name="video[]" multiple accept="video/*">
                            </label>

                            <div class="md-form">
                                <select name="symptoms" multiple data-placeholder="Target users">
                                    <option value="all">All</option>
                                    <option value="under 18">Under 18</option>
                                    <option value="Adults">Adults</option>
                                    <option value="males">Males</option>
                                    <option value="females">Females</option>
                                    <option value="married">Married</option>
                                    <option value="single">Single</option>
                                    <option value="americans">Americans</option>
                                </select>
                            </div>
                            <button class="btn btn-block blue-gradient btn-rounded mt-3 p-3" type="submit">Advertise</button>
                        </form>
                        <br/>

                    </div>

                </div>
            </div>
         
          <!-- Heading -->
            <div class="row wow fadeIn">
                <!--Grid column-->
                <div class="col-md-12 mb-4">

                    <!--Card-->
                    <div class="card">
                        <div class="card-header text-center">Previous Advertisements</div>
                        <!--Card content-->
                        <div class="card-body">

                            <!-- Table  -->
                            <table class="table table-hover">
                                <!-- Table head -->
                                <thead class="blue lighten-4">
                                <tr>
                                    <th>#</th>
                                    <th>Post Date</th>
                                    <th>Post Text</th>
                                </tr>
                                </thead>
                                <!-- Table head -->

                                <!-- Table body -->
                                <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>11-12-19</td>
                                    <td>This is a post</td>
                                </tr>
                                </tbody>
                                <!-- Table body -->
                            </table>
                            <!-- Table  -->

                        </div>

                    </div>
                    <!--/.Card-->

                </div>
                <!--Grid column-->

            </div>
        </div>
  </main>

<jsp:include page="/WEB-INF/jsp/includes/dashboard-footer.jsp"></jsp:include>