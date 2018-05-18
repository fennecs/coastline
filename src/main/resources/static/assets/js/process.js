var imgName = '';

$(document).ready(function () {
    // 保存文件名
    var request = getRequest();
    imgName = request['imgName'];
    // 填充图片
    placeOrigin();
    // 步骤插件
    $('#rootwizard').bootstrapWizard({
        onTabShow: function (tab, navigation, index) {
            var $total = navigation.find('li').length;
            var $current = index + 1;
            var $percent = ($current / $total) * 100;
            $('#rootwizard .progress-bar').css({width: $percent + '%'});
        },
        tabClass: 'nav nav-tabs'
    });
    window.prettyPrint && prettyPrint()
});


function getRequest() {
    var url = location.search; //获取url中'?'符后的字串
    var theRequest = {};
    if (url.indexOf('?') !== -1) {
        var str = url.substr(1);
        strs = str.split('&');
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split('=')[0]] = decodeURIComponent(strs[i].split('=')[1]);
        }
    }
    return theRequest;
}

$(document).on('click', '#blurFormButton', function () {
    var ksize = $('#ksize').val();
    $.ajax({
        url: 'http://' + server_address + '/blur',
        type: 'POST',
        data: {
            imgName: imgName,
            ksize: ksize
        },
        dataType: 'json',
        beforeSend: function () {
            $('#loading').show();
        },
        complete: function () {
            $('#loading').hide();
        },
        success: function (data) {
            if (data.code !== 10000) {
                toastr.error(data.message);
                return
            }

            toastr.success('处理完成');
            placeGray();
        },
        error: function () {
            toastr.error('服务器异常');
        }
    })
});

function placeGray() {
    var timestamp = new Date().getTime();
    var path = 'http://' + server_address + '/process_images/gray/' + imgName + '?t=' + timestamp;
    $('#blurPreview').attr('href', path);
    $('#blurImg').attr('src', path);
}

function placeOrigin() {
    var timestamp = new Date().getTime();
    var originPath = 'http://' + server_address + '/process_images/origin/' + imgName + '?t=' + timestamp;
    $('#originPreview').attr('href', originPath);
    $('#originImg').attr('src', originPath);
}

$(document).on('click', '#getChartsBtn', function () {
    $.ajax({
        url: 'http://' + server_address + '/charts',
        type: 'GET',
        dataType: 'json',
        data: {
            imgName: imgName
        },
        beforeSend: function () {
            $('#loading').show();
        },
        complete: function () {
            $('#loading').hide();
        },
        success: function (data) {
            console.log(data);
            if (data.code !== 10000) {
                toastr.error(data.message);
                return
            }

            var myChart = echarts.init(document.getElementById('charts'));
            var option = {
                title: {
                    text: ''
                },
                tooltip: {},
                legend: {
                    data: ['灰度数量（已归一化）']
                },
                xAxis: {
                    data: data.module.binList
                },
                yAxis: {},
                series: [{
                    name: '灰度数量（已归一化）',
                    type: 'bar',
                    data: data.module.valueList
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);

            myChart.on('click', function (param) {
                console.log(param.name);
                $('#threshold').val(param.name);
            });

            toastr.success('处理完成');
        },
        error: function () {
            toastr.error('服务器异常');
        }
    })
});



$(document).on('click', '#getThresholdImgBtn', function () {
    var thresholdVal = $('#threshold').val();
    $.ajax({
        url: 'http://' + server_address + '/threshold',
        type: 'POST',
        dataType: 'json',
        data: {
            imgName: imgName,
            threshold: thresholdVal
        },
        beforeSend: function () {
            $('#loading').show();
        },
        complete: function () {
            $('#loading').hide();
        },
        success: function (data) {
            console.log(data);
            if (data.code !== 10000) {
                toastr.error(data.message);
                return;
            }

            placeThreshold();
            toastr.success('处理完成');
        },
        error: function () {
            toastr.error('请求异常');
        }
    })
});

function placeThreshold() {
    var timestamp = new Date().getTime();
    var thresholdPath = 'http://' + server_address + '/process_images/threshold/' + imgName + '?t=' + timestamp;
    $('.thresholdPreview').attr('href', thresholdPath);
    $('.thresholdImg').attr('src', thresholdPath);
}

// slider 滚动条
$('#ex1').slider({
    formatter: function (value) {
        return 'Current value: ' + value;
    },
    tooltip: 'always'
}).on('slideStop', function (event) {
    console.log(event.value);
    getEdgeImg(event.value);
});

function getEdgeImg(data) {
    var thresholdVal = $('#threshold').val();
    $.ajax({
        url: 'http://' + server_address + '/edge',
        type: 'POST',
        dataType: 'json',
        data: {
            imgName: imgName,
            threshold: thresholdVal,
            cannyThreshold: data
        },
        beforeSend: function () {
            $('#loading').show();
        },
        complete: function () {
            $('#loading').hide();
        },
        success: function (data) {
            console.log(data);
            if (data.code !== 10000) {
                toastr.error(data.message);
                return;
            }

            placeEdgeImg();
            toastr.success('处理完成');
        },
        error: function () {
            toastr.error('请求异常');
        }
    })
}

function placeEdgeImg() {
    var timestamp = new Date().getTime();
    var edgePath = 'http://' + server_address + '/process_images/edge/' + imgName + '?t=' + timestamp;
    $('.edgePreview').attr('href', edgePath);
    $('.edgeImg').attr('src', edgePath);
}

$(document).on('click', '#getLength', function () {
    var thresholdVal = $('#threshold').val();
    var cannyThreshold = $('#ex1').slider().slider('getValue');
    console.log('getValue' + cannyThreshold);
    $.ajax({
        url: 'http://' + server_address + '/coastlineLength',
        type: 'GET',
        dataType: 'json',
        data: {
            imgName: imgName,
            cannyThreshold: cannyThreshold,
            threshold: thresholdVal
        },
        beforeSend: function () {
            $('#loading').show();
        },
        complete: function () {
            $('#loading').hide();
        },
        success: function (data) {
            console.log(data);
            if (data.code !== 10000) {
                toastr.error(data.message);
                return;
            }

            $('#coastlineLength').val(data.module);
            toastr.success('处理完成');
        },
        error: function () {
            toastr.error('请求异常');
        }
    })
});

$(document).on('click', '#finishProcess', function () {
    window.location.href = 'index.html';
});