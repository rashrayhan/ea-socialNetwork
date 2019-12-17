<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/jsp/includes/dashboard-header.jsp"></jsp:include>

    
  <main class="pt-5 mx-lg-5">
        <div class="container-fluid mt-5">
            <div class="d-flex justify-content-center">
                <div class="card mb-5 wow fadeIn col-8">

                    <div class="card-body d-sm-flex text-center">

                        <form:form modelAttribute="advert" cssClass="form col-12 p-5" action="" method="post" enctype="multipart/form-data">
                            <form:input path="title" cssClass="form-control mb-3 p-2" autofocus="true" placeholder="Enter advertisement title"/>
                            <form:errors cssClass="text-danger" path="title"/>

                            <form:textarea path="content" cssClass="form-control mr-sm-2 p-2" rows="5" placeholder="Enter advertisement text"/>
                            <form:errors cssClass="text-danger" path="content"/>

                            <form:label cssClass="btn purple-gradient btn-sm" path="pictures"> <i class="fa fa-image"></i><form:input path="pictures" type="file" cssClass="uploadFile"  multiple="true" accept="image/*"/>
                            </form:label>
                            <form:errors cssClass="text-danger" path="title"/>

                            <form:label cssClass="btn aqua-gradient btn-sm" path="videos"> <i class="fa fa-video"></i><form:input path="videos" type="file" cssClass="uploadFile"  multiple="true" accept="video/*"/>
                            </form:label>
                            <form:errors cssClass="text-danger" path="mediaList"/>

                            <div class="md-form">
                                <form:select path="target_users" multiple="true" data-placeholder="Target users">
                                    <option value="all">All</option>
                                    <option value="under 18">Under 18</option>
                                    <option value="Adults">Adults</option>
                                    <option value="males">Males</option>
                                    <option value="females">Females</option>
                                    <option value="married">Married</option>
                                    <option value="single">Single</option>
                                    <option value="americans">Americans</option>
                                </form:select>
                            </div>
                            <form:button class="btn btn-block blue-gradient btn-rounded mt-3 p-3" type="submit">Advertise</form:button>
                        </form:form>
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