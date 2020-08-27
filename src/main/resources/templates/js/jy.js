
// document.write("<script language='javascript' src='../jquery-3.2.1.min.js'></script>");

//引入css <link href="../css/toastr.min.css" rel="stylesheet" type="text/css" />
new_element=document.createElement("link");
new_element.setAttribute("rel","stylesheet");
new_element.setAttribute("type","text/css");
new_element.setAttribute("href","../css/toastr.min.css");
document.body.appendChild(new_element);
//引入js
document.write("<script src='../js/toastr.min.js'></script>");
document.write("<script language='javascript' src='../jquery-3.2.1.min.js'></script>");

//弹框位置方法
function TopCenter() {
    //自定义弹出框位置
    toastr.options = {
        "positionClass": "toast-top-center"//弹出窗的位置上方居中
    };
}

//非空校验
function isNull(param){
    TopCenter();
    if(param==null||param==""){
        toastr.warning("内容不可为空");
        return false;
    }
    return true;
}

//特殊字符校验
function isTeshuzi(param){
    TopCenter();
    //判断密码中是否有特殊字符
    var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>《》/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
    if(pattern.test(param)){
        toastr.warning('不可包含 " . {} <> # $ " 等特殊字符');
        return false;
    }
    return true
}

//密码校验
function isPwd(param) {
    TopCenter();
    //判断密码是否为空
    if(!isNull(param)){
        return false;
    }
    //判断密码长度
    if(param.length<6){
        toastr.warning("密码过短,正确长度为6-12位置");
        return false;
    }
    //判断密码中是否有特殊字符
    if(!isTeshuzi(param)){
        return false;
    }
    return true
}

//手机号校验
function isPhone(param){
    TopCenter();
    if(param.length!=11){
        toastr.warning("手机号格式错误");
        return false;
    }
    return true;
}



