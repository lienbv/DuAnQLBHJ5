<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="row pl-0">
                <div class="col-sm-8 pr-1 pl-0">
                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="/img/0523158452a3e8ba309588cdf95d9357.png.webp" class="d-block w-100 "
                                    alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="/img/59785fc7d7303bd465ec34bf12f21638.png.webp" class="d-block w-100"
                                    alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="/img/950f7b17402baed2cd7511ed7e5136bf.png.webp" class="d-block w-100"
                                    alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button"
                            style="border: none; background-color: transparent;"
                            data-target="#carouselExampleIndicators" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button"
                            style="border: none; background-color: transparent;"
                            data-target="#carouselExampleIndicators" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </button>
                    </div>
                </div>
                <div class="col-sm-4  pl-1 py-0 pr-0">
                    <img src="/img/060951ff0fb2bf617ab8cb2b814984bc.png.webp" class="d-block w-100 h-100 "
                        alt="...">
                </div>

            </div>

        </div>

    </div>

    <div class="row py-2 ">
        <div class="col-sm-12 px-0">

            <div class="row  px-0 mx-auto" style="min-height: 300px;">
                <div class="col-sm-3 col-xs-12 bg-light ">
                    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist"
                        aria-orientation="vertical">
                        <a class="nav-link active text-dark" id="v-pills-home-tab" data-toggle="pill"
                            href="#v-pills-home" role="tab" aria-controls="v-pills-home"
                            aria-selected="true">Profile</a>
                        <a class="nav-link text-dark" id="v-pills-profile-tab" data-toggle="pill"
                            href="#v-pills-profile" role="tab" aria-controls="v-pills-profile"
                            aria-selected="false">Change Password</a>
                        <a class="nav-link text-dark" id="v-pills-messages-tab" data-toggle="pill"
                            href="#v-pills-messages" role="tab" aria-controls="v-pills-messages"
                            aria-selected="false">Bill Manager</a>

                    </div>
                </div>
                <div class="col-sm-9 col-xs-12 mx-auto px-0">
                    <div class="tab-content" id="v-pills-tabContent">
                        <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel"
                            aria-labelledby="v-pills-home-tab">
                            <h4 class="text-center" style="color: rgb(75, 73, 72);">Thong tin tai khoan</h4>
                            <div class="col-sm-12">
                                <img class=" rounded shadow my-sm-4" src="/img/download.png" alt="">
                                <form name="formUpdate" class="bg-light">

                                    <div class="form-group">
                                        <label for="fullname">Fullname</label>
                                        <input name="txtFullname" type="text" class="form-control" required
                                            maxlength="60" minlength="4" id="fullname"
                                            aria-describedby="emailHelp">

                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input name="txtEmail" type="email" class="form-control" required
                                            maxlength="30" minlength="4" id="email"
                                            aria-describedby="emailHelp">

                                    </div>

                                    <div class="form-group">
                                        <label for="birthday">Date(dd/MM/yyyy)</label>
                                        <input name="birthday" type="text" id="birthday"
                                            class="form-control border-indigo" required>

                                    </div>

                                    <div class="form-group">
                                        <button type="submit" class="btn btn-dark ">Submit</button>
                                        <button type="submit" class="btn btn-dark ">Hủy</button>
                                    </div>

                                </form>

                            </div>
                        </div>
                        <div class="tab-pane fade px-sm-2" id="v-pills-messages" role="tabpanel"
                            aria-labelledby="v-pills-messages-tab">
                            <h4 class="text-center py-sm-2 " style="color: rgb(75, 73, 72);">Bill Manager</h4>
                            <table class="table table-bordered  m-0">
                                <thead>
                                    <tr class="text-center">
                                        <th>Purchase date</th>
                                        <th>Amount</th>
                                        <th>Discount</th>
                                        <th>Total Money</th>
                                    </tr>

                                </thead>
                                <tbody>
                                    <tr class="bg-warning">
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>

                        <div class="tab-pane fade px-sm-2" id="v-pills-profile" role="tabpanel"
                            aria-labelledby="v-pills-profile-tab">
                            <h4 class="text-center" style="color: rgb(75, 73, 72);">Change password</h4>
                            <form name="formUpdate" class="bg-light">

                                <div class="form-group">
                                    <label for="pass_old">Password old</label>
                                    <input name="pass_old" type="password" class="form-control" required
                                        maxlength="60" minlength="4" id="pass_old" aria-describedby="pass_old">

                                </div>
                                <div class="form-group">
                                    <label for="pass_new">Password new</label>
                                    <input name="pass_new" type="pass_new" class="form-control" required
                                        maxlength="30" minlength="4" id="pass_new" aria-describedby="pass_new">

                                </div>
                                <div class="form-group">
                                    <label for="comfirmPass">Confirm Password</label>
                                    <input name="confirmPass" type="text" class="form-control" required
                                        maxlength="60" minlength="4" id="comfirmPass"
                                        aria-describedby="comfirmPass">

                                    <div class="form-group">
                                        <button type="submit" class="btn btn-dark ">Submit</button>
                                        <button type="submit" class="btn btn-dark ">Hủy</button>
                                    </div>

                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>
