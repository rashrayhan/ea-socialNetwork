<jsp:include page="/WEB-INF/jsp/includes/dashboard-header.jsp"></jsp:include>

    
  <main class="pt-5 mx-lg-5">
        <div class="container-fluid mt-5">
            <div class="row wow fadeIn">
                <!--Grid column-->
                <div class="col-md-12 mb-4">

                    <!--Card-->
                    <div class="card">
                        <div class="h5 card-header text-center">Filthy posts</div>
                        <!--Card content-->
                        <div class="card-body">

                            <!-- Table  -->
                            <table id="table_id" class="display table table-striped">
                                <!-- Table head -->
                                <thead class="blue lighten-4">
                                <tr>
                                    <th>#</th>
                                    <th>Date</th>
                                    <th>Poster</th>
                                    <th>Filthy texts</th>
                                    <th class="text-center">Actions</th>
                                </tr>
                                </thead>
                                <!-- Table head -->

                                <!-- Table body -->
                                <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>11-12-2019</td>
                                    <td>test@mum.edu</td>
                                    <td>fuck, pussy, sex</td>
                                    <td class="text-center">
                                        <a href="#" class="mx-2" role="button" title="delete post"><i class="fa fa-trash-alt text-warning"></i></a>
                                        <a href="#" class="mx-2" role="button" title="block user (delete post as well)"><i class="fa fa-user-lock text-danger"></i></a>
                                    </td>
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