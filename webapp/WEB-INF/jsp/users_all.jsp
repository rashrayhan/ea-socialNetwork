<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/includes/dashboard-header.jsp"></jsp:include>


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
                            <!-- Table head -->
                            <thead class="blue lighten-4">
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Username</th>
                                <th>DOB</th>
                                <th>Email</th>
                                <th>Status</th>
                                <th>Action(s)</th>
                            </tr>
                            </thead>
                            <!-- Table head -->

                            <!-- Table body -->
                            <tbody>
                            <c:forEach items="${users}" var="users" varStatus="loop">
                                <tr>
                                    <th scope="row">${loop.count}</th>
                                    <td>${users.surname} ${users.otherNames}</td>
                                    <td>${users.username}</td>
                                    <td>${users.dateOfBirth}</td>
                                    <td>${users.email}</td>
                                    <td>${users.accountStatus}</td>
                                    <td>
                                        <a href="users_all/block/${users.id}" class="mx-2" role="button" title="block user"><i class="fa fa-user-lock text-danger"></i></a>
                                        <a href="users_all/unblock/${users.id}" class="mx-2" role="button" title="unblock user"><i class="fa fa-lock-open text-success"></i></a>
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