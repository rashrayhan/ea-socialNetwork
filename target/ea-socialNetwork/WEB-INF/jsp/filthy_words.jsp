<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/jsp/includes/dashboard-header.jsp"></jsp:include>

    
  <main class="pt-5 mx-lg-5">
        <div class="container-fluid mt-5">
           <div class="row float-right">
               <button class="btn blue-gradient btn-rounded p-3" type="button" data-toggle="modal" data-target="#addModal">
                   <i class="fa fa-plus-square"></i> Add new
               </button>
           </div>

            <div class="row wow fadeIn" style="clear: both;">

                <!--Grid column-->
                <div class="col-md-12 mb-4">

                    <!--Card-->
                    <div class="card">
                        <div class="h5 card-header text-center">Filthy Words</div>
                        <!--Card content-->
                        <div class="card-body">

                            <!-- Table  -->
                            <table id="table_id" class="display table table-striped">
                                <!-- Table head -->
                                <thead class="blue lighten-4">
                                <tr>
                                    <th>#</th>
                                    <th>Word</th>
                                    <th>Meaning</th>
                                    <th class="text-center">Actions</th>
                                </tr>
                                </thead>
                                <!-- Table head -->

                                <!-- Table body -->
                                <tbody>
                                    <c:forEach items="${filthy_words}" var="filthy_words" varStatus="loop">
                                        <tr>
                                            <th scope="row">${loop.count}</th>
                                            <td>${filthy_words.name}</td>
                                            <td>${filthy_words.meaning}</td>
                                            <td class="text-center">
                                                <a href="filthy_words/delete/${filthy_words.id}" class="mx-2 tooltip-test" role="button" title="delete word"><i class="fa fa-trash-alt text-danger"></i></a>
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

<!-- Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">New Filthy Word</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form:form modelAttribute="filthyWord" method="post" action="">
                    <!--Grid row-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="md-form mb-0">
                                <form:input  path="name" type="text" cssClass="form-control" id="word" autofocus="true"/>
                                <form:label path="name">Word</form:label>
                                <form:errors cssClass="text-danger" path="name"/>
                            </div>
                        </div>
                    </div>
                    <!--Grid row-->

                    <!--Grid row-->
                    <div class="row">

                        <!--Grid column-->
                        <div class="col-md-12">

                            <div class="md-form">
                                <form:label for="meaning" path="meaning">Word Meaning</form:label>
                                <form:textarea cssClass="form-control md-textarea" rows="3" path="meaning"/>
                                <form:errors cssClass="text-danger" path="meaning"/>
                            </div>

                        </div>
                    </div>
                    <!--Grid row-->
                    <div class="modal-footer">
                        <form:button type="button" class="btn btn-secondary" data-dismiss="modal">Close</form:button>
                        <form:button type="submit" class="btn btn-primary">Add</form:button>
                    </div>
                </form:form>
            </div>

        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/jsp/includes/dashboard-footer.jsp"></jsp:include>