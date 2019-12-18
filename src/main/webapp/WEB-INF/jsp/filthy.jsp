<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <c:forEach items="${filthy}" var="filthy">
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>${filthy.activityTime}</td>
                                        <td>${filthy.user.username}</td>
                                        <td>${filthy.content}</td>
                                        <td class="text-center">
                                            <a href="filthy/delete/${filthy.id}" class="mx-2" role="button" title="delete post"><i class="fa fa-trash-alt text-warning"></i></a>
                                            <a href="filthy/block/${filthy.user.id}/${filthy.id}" class="mx-2" role="button" title="block user (delete post as well)"><i class="fa fa-user-lock text-danger"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
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