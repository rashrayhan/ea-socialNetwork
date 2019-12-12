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
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Cunt</td>
                                    <td>One of the most offensive dirty words, referring to a vagina</td>
                                    <td class="text-center">
                                        <a href="#" class="mx-2 tooltip-test" role="button" title="delete word"><i class="fa fa-trash-alt text-danger"></i></a>
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
                <form method="post" action="">
                    <!--Grid row-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="word"  name="word">
                                <label for="word">Word</label>
                            </div>
                        </div>
                    </div>
                    <!--Grid row-->

                    <!--Grid row-->
                    <div class="row">

                        <!--Grid column-->
                        <div class="col-md-12">

                            <div class="md-form">
                                <label for="meaning">Word Meaning</label>
                                <textarea class="form-control md-textarea" id="meaning" name="meaning" rows="3"></textarea>
                            </div>

                        </div>
                    </div>
                    <!--Grid row-->
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Add</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/jsp/includes/dashboard-footer.jsp"></jsp:include>