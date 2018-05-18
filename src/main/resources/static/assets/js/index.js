$(document).ready(function () {
    loadAreas();
    initDatePicker();
});

function listArea(data) {
    var rows = '';
    var areaRow = $('#areaRow').html();
    data.module.forEach(function (value, index) {
        if (value.coastlineType === 1){
            value.coastlineType = '基岩型海岸线';
        } else if (value.coastlineType === 2){
            value.coastlineType = '人工型海岸线'
        } else {
            value.coastlineType = '沙砾型海岸线'
        }

        if (value.coastlineLength === 0){
            value.coastlineLength = '未计算';
        }

        value.imgDate =

        rows += areaRow.temp(value);
    });
    $('#areaRows').html(rows);
}

function loadAreas() {
    $.ajax({
        url: 'http://' + server_address + '/areas',
        type: 'GET',
        dataType: 'json',
        beforeSend: function() {
            $('#loading').show();
        },
        complete: function(){
            $('#loading').hide();
        },
        success: function (data) {
            var msg = '加载列表完成';
            if (data.module.length === 0){
                msg += ', 暂无数据'
            }
            toastr.success(msg);
            listArea(data);
        },
        error: function () {
            toastr.error('加载列表失败，服务器异常');
        }
    })
}

function initDatePicker() {
    $('.form_date_begin').datetimepicker({
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: 'yyyy-mm-dd'
    });
    $('.form_date_end').datetimepicker({
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: 'yyyy-mm-dd'
    });
}

$(document).on('click', '#searchAreas', function () {
    var timeBegin = $('#timeBegin').val();
    var timeEnd = $('#timeEnd').val();
    var areaName = $('#areaName').val();
    $.ajax({
        url: 'http://' + server_address + '/areas',
        type: 'GET',
        data: {
            timeBegin: timeBegin,
            timeEnd: timeEnd,
            areaName: areaName
        },
        dataType: 'json',
        beforeSend: function() {
            $('#loading').show();
        },
        complete: function(){
            $('#loading').hide();
        },
        success: function (data) {
            var msg = '加载列表完成';
            if (data.module.length === 0){
                msg += ', 暂无数据'
            }
            toastr.success(msg);
            listArea(data);
        },
        error: function () {
            toastr.error('加载列表失败，服务器异常');
        }
    })
});
