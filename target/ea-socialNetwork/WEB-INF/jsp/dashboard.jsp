<jsp:include page="/WEB-INF/jsp/includes/dashboard-header.jsp"></jsp:include>

    
  <main class="pt-5 mx-lg-5">

        <div class="container-fluid mt-5">
            <div class="d-flex justify-content-center">
                <div class="card mb-5 wow fadeIn col-8">
                    <div class="card-body d-sm-flex text-center">
                        <form class="form col-12 p-5" action="" method="post">
                            <textarea class="form-control mr-sm-2 p-4" name="advertisemet" placeholder="Enter advertisement text"></textarea>

                            <button class="btn btn-block blue-gradient btn-rounded mt-3 p-3" type="submit">Advertise</button>
                        </form>
                        <br/>

                    </div>
                    <div id="drop-area">
                        <form class="my-form">
                            <p>Upload multiple files with the file dialog or by dragging and dropping images onto the dashed region</p>
                            <input type="file" id="fileElem" multiple accept="image/*" onchange="handleFiles(this.files)">
                            <label class="button" for="fileElem">Select some files</label>
                        </form>
                    </div>
                </div>
            </div>
         
          <!-- Heading -->

        </div>
      </main>
      <!--Main layout-->

<jsp:include page="/WEB-INF/jsp/includes/dashboard-footer.jsp"></jsp:include>