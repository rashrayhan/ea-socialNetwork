<jsp:include page="/WEB-INF/jsp/includes/dashboard-header.jsp"></jsp:include>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<main class="pt-5 mx-lg-5">
    <div class="container-fluid mt-5">
        <div class="row wow fadeIn">
            <!--Grid column-->
            <div class="col-md-12 mb-4">

                <!--Card-->
                <div class="card">
                    <div class="h4 card-header text-center">System Users</div>
                    <!--Card content-->
                    <div class="card-body">

                        <!-- Table  -->
                        <table id="table_id" class="display table table-striped">
                            <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
                            <!-- Table head -->
                            <thead class="blue lighten-4">

                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Account creation date</th>
                                <th>YOB</th>
                                <th>Email</th>
                                <th>Status</th>
                                <th>Action(s)</th>
                            </tr>

                            </thead>
                            <!-- Table head -->

                            <!-- Table body -->
                            <tbody>
<c:forEach var="item" items="${userList}">
                            <tr>
                                <th scope="row">1</th>
                                <td>${item.email}</td>
                                <td>${item.surname}</td>
                                <td>${item.otherNames}</td>
                                <td>${item.dateOfBirth}</td>
                                <td>${item.username}</td>
                                <td>
                                    <a href="#" class="mx-2" role="button" title="block user"><i class="fa fa-user-lock text-danger"></i></a>
                                    <a href="#" class="mx-2" role="button" title="unblock post"><i class="fa fa-lock-open text-success"></i></a>
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