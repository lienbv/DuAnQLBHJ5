var urlName = location.href;
var successRegister = urlName.search("successRegister");
var successLogin =urlName.search("successLogin");
var successLogout = urlName.search("successLogout");
var successForgot = urlName.search("successForgot");
var successUpdateDrinking = urlName.search("successUpdateDrinking");
var successCreateDrinking = urlName.search("successCreateDrinking");
var Error = urlName.search("Error");
var successAddToCart = urlName.search("successAddToCart");
var successCheckoutCart = urlName.search("successCheckoutCart")
var successConfirm = urlName.search("successConfirm");
var successCancel = urlName.search("successCancel")
var successDelete = urlName.search("successDelete");
if(successRegister>0){
    alert("Register Success")
}
if(successLogin>0){
    alert("Login Success")
}
if(successLogout>0){
    alert("Logout Success")
}
if(successForgot > 0){
    alert("We have emailed you inviting you to check")
}
if(successUpdateDrinking >0){
    alert("Update drinking cup success")
}
if(successCreateDrinking>0){
    alert("Create drinking cup success")
}
if(Error>1){
    alert("Bạn cần phải đăng nhập")
}
if(successAddToCart>1){
    alert("Thêm vào giỏ hàng thành công");
}
if(successCheckoutCart>1){
    alert("Successful payment")
}
if(successConfirm >1){
    alert("Successful order confirmation")
}
if(successCancel >1){
    alert("Successful order cancel")
}
if(successDelete >1){
    alert("Successfull delete drinking cups ")
}

