$(document).ready(function () {
    $('.form_date').datetimepicker({
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: 'yyyy-mm-dd'
    });
});

$(document).on('click', '#newImage', function () {
    $.ajax({
        url: 'http://' + server_address + '/upload',
        type: 'POST',
        cache: false,
        data: new FormData(document.getElementById('uploadForm')),
        processData: false,
        contentType: false,
        dataType: 'json',
        beforeSend: function() {
            $('#loading').show();
        },
        complete: function(){
            $('#loading').hide();
        },
        success: function (data) {
            if (data.code !== 10000){
                toastr.error(data.message);
                return
            }

            toastr.success('图片处理完成，3秒开始处理');
            setTimeout(function () {
                window.location.href = 'process.html?imgName=' + data.module;
            }, 3000);

        },
        error: function () {
            toastr.error('服务器异常');
        }
    });
});

$(document).on('change', "#coastlineType", function () {
    var coastlineType = $(this).val();
    console.log('coastlineType:' + coastlineType);
    if (coastlineType == 3){
        $('#averageLevelDiv').fadeIn();
        $('#gapDiv').fadeIn();
        $('#2ndImgDiv').fadeIn();

    }else {
        $('#averageLevelDiv').fadeOut();
        $('#gapDiv').fadeOut();
        $('#2ndImgDiv').fadeOut();
    }
});