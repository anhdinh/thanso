function isVowel(x) {
    var result;
    result = x == "a" || x == "e" || x == "i" || x == "o" || x == "u" || x == "y" ;
    return result;
}

function removeVietnameseTones(str){
    str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g,"a");
    str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g,"e");
    str = str.replace(/ì|í|ị|ỉ|ĩ/g,"i");
    str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g,"o");
    str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g,"u");
    str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g,"y");
    str = str.replace(/đ/g,"d");
    str = str.replace(/À|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ/g, "A");
    str = str.replace(/È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ/g, "E");
    str = str.replace(/Ì|Í|Ị|Ỉ|Ĩ/g, "I");
    str = str.replace(/Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ/g, "O");
    str = str.replace(/Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ/g, "U");
    str = str.replace(/Ỳ|Ý|Ỵ|Ỷ|Ỹ/g, "Y");
    str = str.replace(/Đ/g, "D");
    // Some system encode vietnamese combining accent as individual utf-8 characters
    // Một vài bộ encode coi các dấu mũ, dấu chữ như một kí tự riêng biệt nên thêm hai dòng này
    str = str.replace(/\u0300|\u0301|\u0303|\u0309|\u0323/g, ""); // ̀ ́ ̃ ̉ ̣  huyền, sắc, ngã, hỏi, nặng
    str = str.replace(/\u02C6|\u0306|\u031B/g, ""); // ˆ ̆ ̛  Â, Ê, Ă, Ơ, Ư
    // Remove extra spaces
    // Bỏ các khoảng trắng liền nhau
    str = str.replace(/ + /g," ");
    str = str.trim();
    // Remove punctuations
    // Bỏ dấu câu, kí tự đặc biệt
    str = str.replace(/!|@|%|\^|\*|\(|\)|\+|\=|\<|\>|\?|\/|,|\.|\:|\;|\'|\"|\&|\#|\[|\]|~|\$|_|`|-|{|}|\||\\/g," ");
    return str;
}

function tinh_so_linh_hon_va_nhan_cach(name){
    let result  = {
        linh_hon:0,
        nhan_cach: 0
    }
    name =  name.toLowerCase();
    name = removeVietnameseTones(name);
    name = name.replace(/\s/g, '');
    let array_characters =name.split("");
    let array_vowels = [];
    let array_consonants = []
    array_characters.forEach(function (value) {
        if(isVowel(value)){
            array_vowels.push(value)
        }else {
            array_consonants.push(value);
        }
    });

    let con_so_linh_hon = 0;

    array_vowels.forEach(function (value,index) {
       con_so_linh_hon += returnNumberFromCharacter(value);
    });

    con_so_linh_hon = handle_the_number(con_so_linh_hon);

    let con_so_nhan_cach = 0;
    array_consonants.forEach(function (value,index) {
        con_so_nhan_cach += returnNumberFromCharacter(value);
    });

    con_so_nhan_cach = handle_the_number(con_so_nhan_cach);

    result.linh_hon = con_so_linh_hon;
    result.nhan_cach = con_so_nhan_cach;

    return result;
}

function handle_the_number(number) {
    if(number==10){
        return 1;
    }else if(number==11){
        return 11;
    }
    else if(number==22){
        return 22;
    }
    else if(number==33){
        return 33;
    }else if(number>10){
        var digits = number.toString().split('');
        var realDigits = digits.map(Number)
        let the_number = 0;
        realDigits.forEach(function (item) {
            the_number += item;
        });
        if(the_number>=10){
           return handle_the_number(the_number);
        }else {
            return the_number;
        }
    }else if(number<10) {
        return number;
    }
}

function returnNumberFromCharacter(char){
    let ajs = 'ajs';
    let bkt = 'bkt';
    let clu = 'clu';
    let dmv = 'dmv';
    let enw = 'enw';
    let fox = 'fox';
    let gpy = 'gpy';
    let hqz = 'hqz';
    let ir = 'ir';
    if(char == ''){
        throw "please input a character";
    }
     if(ajs.includes(char)){
         return 1;
     }else if(bkt.includes(char)){
         return 2;
     }else if(clu.includes(char)){
         return 3;
     }else if(dmv.includes(char)){
        return 4;
     }else if(enw.includes(char)){
        return 5;
     }else if(fox.includes(char)){
        return 6;
     }else if(gpy.includes(char)){
        return 7;
     }else if(hqz.includes(char)){
        return 8;
     }else if(ir.includes(char)){
        return 9;
     }else {
         throw 'please check the character inputted';
     }
}

$(document).ready(function () {

    // ham de gen selectbox ngay va thang
    gendate = function (id,firstelement,number) {
        let select = $(`#${id}`);
        select.find('option')
            .remove()
            .end().append(`<option selected>${firstelement}</option>`);
        for (let x =1;x<=number;x++){
            select.append(`<option value="${x}">${x}</option>`);

        }
    }
    // gen select box ngay sinh
    gendate("ngay",'Ngày',31);
    // gen select box thang
    gendate("thang",'Tháng',12);
    // gen select box year
    let nam =$("#nam");
    let current_year = new Date().getFullYear();
    nam.find('option').remove().end().append('<option selected>Năm</option>')
    for (let x =current_year;x>=1960;x--){
        nam.append(`<option value="${x}">${x}</option>`);

    }




    $("#xemketqua").click(function () {
        //validate form

        //get values from form
        let ngay = $("#ngay").val();
        let thang =$("#thang").val();
        let nam = $("#nam").val();
        let name = $("#input_name").val();
        let short_name=$("#input_short_name").val();
        // set them to places holder
        let ngayText = ngay>=10?ngay:"0"+ngay;
        let thangText = thang>=10?thang:"0"+thang;
        let ngaySinhfull= `${ngayText}/${thangText}/${nam}.`;

        $("#name").text(name.toUpperCase());



        $("#short-name").text(short_name);

        $('#ngaysinhfull').text(ngaySinhfull);

        $("#birth").text(ngaySinhfull);

        let ngaySinhFullText = `${ngay}${thang}${nam}`;

        let arrayNgaySinhFullText = ngaySinhFullText.split("");

        let tongCacSoTrongNgaySinh =0;
        let cacSoTongText = ""

        arrayNgaySinhFullText.forEach(function (item,index) {
            if(index == 0){
                cacSoTongText = item.toString()
            }else{
                cacSoTongText = cacSoTongText+"+"+item.toString()
            }
            tongCacSoTrongNgaySinh=tongCacSoTrongNgaySinh+parseInt(item);
        });

        if(tongCacSoTrongNgaySinh>10 && tongCacSoTrongNgaySinh!=11&& tongCacSoTrongNgaySinh!=22&&tongCacSoTrongNgaySinh!=33){
            arrayNgaySinhFullText = tongCacSoTrongNgaySinh.toString().split("");

            arrayNgaySinhFullText.forEach(function (item,index) {
                if(index == 0){
                    cacSoTongText = cacSoTongText+"="+tongCacSoTrongNgaySinh+"="+item.toString()
                    tongCacSoTrongNgaySinh =0
                }else{
                    cacSoTongText = cacSoTongText+"+"+item.toString()
                }
                tongCacSoTrongNgaySinh=tongCacSoTrongNgaySinh+parseInt(item);
            });
        }

        // tinh con so chu dao
        let consochudaoText=cacSoTongText+"="+tongCacSoTrongNgaySinh;
        $("#consochudaoText").text(consochudaoText)

        let  tongSoNgaySinhtext = "";
        let tongConSoNgaySinhNum =0;
        let arraySoNgaySinh = ngay.split("");
        arraySoNgaySinh.forEach(function (item,index) {
            if(index == 0){
                tongSoNgaySinhtext = item.toString()
            }else{
                tongSoNgaySinhtext = tongSoNgaySinhtext+"+"+item.toString()
            }
            tongConSoNgaySinhNum=tongConSoNgaySinhNum+parseInt(item);
        });

        $("#soNgaySinhText").text(tongSoNgaySinhtext);
        if(ngay>10){
            $("#soNgaySinhTong").text("="+tongConSoNgaySinhNum);
        }

        // chi so thai do

        let chuoi_ngay_thang =ngay.toString()+thang.toString();

        let chuoi_ngay_thang_text = "";

        let chuoi_ngay_thang_num =0;

        let array_number_ngay_thang = chuoi_ngay_thang.split("");

        array_number_ngay_thang.forEach(function (item,index) {

            if(index == 0){
                chuoi_ngay_thang_text = item.toString()
            }else{
                chuoi_ngay_thang_text = chuoi_ngay_thang_text+"+"+item.toString()
            }
            chuoi_ngay_thang_num = chuoi_ngay_thang_num+parseInt(item);
        });

        if(chuoi_ngay_thang_num>10&& chuoi_ngay_thang_num!=11 && chuoi_ngay_thang_num!=22 && chuoi_ngay_thang_num!=33){
            array_number_ngay_thang = chuoi_ngay_thang_num.toString().split("");
            array_number_ngay_thang.forEach(function (item,index) {
                if(index==0){
                    chuoi_ngay_thang_text=chuoi_ngay_thang_text+"="+chuoi_ngay_thang_num+"="+item.toString();
                    chuoi_ngay_thang_num = 0;
                }else{
                    chuoi_ngay_thang_text = chuoi_ngay_thang_text+"+"+item.toString()
                }
                chuoi_ngay_thang_num=chuoi_ngay_thang_num+parseInt(item);
            });

        }

        $("#conSoThaiDoText").text(chuoi_ngay_thang_text+"="+chuoi_ngay_thang_num);

         let  ket_qua =    tinh_so_linh_hon_va_nhan_cach(name);
         ket_qua.thai_do = chuoi_ngay_thang_num;
         ket_qua.chu_dao = tongCacSoTrongNgaySinh;
         ket_qua.ngay_sinh = tongConSoNgaySinhNum;
        ket_qua.su_menh = handle_the_number(ket_qua.linh_hon+ket_qua.nhan_cach);
        ket_qua.truong_thanh = handle_the_number(ket_qua.chu_dao+ket_qua.su_menh);
         console.log(ket_qua);
    });
});