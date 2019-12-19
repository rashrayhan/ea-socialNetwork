<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/includes/dashboard-header.jsp"></jsp:include>

    
  <main class="pt-5 mx-lg-5">
        <div class="container-fluid mt-5">
            <div class="row wow fadeIn">
                <!--Grid column-->
                <div class="col-md-12 mb-4">

                    <!--Card-->
                    <div class="card">
                        <div class="h5 card-header text-center">User claims</div>
                        <!--Card content-->
                        <div class="card-body">

                            <!-- Table  -->
                            <table id="table_id" class="display table table-striped">
                                <!-- Table head -->
                                <thead class="blue lighten-4">
                                <tr>
                                    <th>#</th>
                                    <th>Date</th>
                                    <th>username</th>
                                    <th>Claim Description</th>
                                    <th class="text-center">Actions</th>
                                </tr>
                                </thead>
                                <!-- Table head -->

                                <!-- Table body -->
                                <tbody>
                                <c:forEach items="${claims}" var="claims" varStatus="loop">
                                    <tr>
                                        <th scope="row">${loop.count}</th>
                                        <td>${claims.activityTime}</td>
                                        <td>${claims.user.username}</td>
                                        <td>${claims.description}</td>
                                        <td class="text-center">
                                            <a href="user_claims/unblock/${claims.user.id}" class="mx-2" role="button" title="unblock user"><i class="fa fa-lock-open text-success"></i></a>
                                            <a href="user_claims/delete/${claims.user.id}" class="mx-2" role="button" title="delete user"><i class="fa fa-trash-alt text-danger"></i></a>
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