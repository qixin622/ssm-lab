$(document).ready(function(){
    builderIndex();
    calculateWorkload();
    $("#addItemButton").click(
        function () {
            $("#items").children("div").last().after($("#items").children("div").first().clone());
            $("#items").children("div").last().find("input[type=hidden]").remove();
            $("#items").children("div").find("button").click(
                function () {
                    $(this).parent().parent().parent().remove();
                    if ($("#items").children("div").size() == 1) {
                        $("#items").find("button").attr("disabled", true);
                    }
                    builderIndex();
                    calculateWorkload();
                }
            );
            $("#items").find("button").attr("disabled", false);
            builderIndex();
            $(".rate").change(
            	function(){
            		calculateWorkload();
            	}
            );
            $(".workload").change(
                function(){
                    calculateTotalWorkload();
                }
            );
            calculateWorkload();
        }
    );
    $("#items").children("div").find("button").click(
        function () {
            if ($("#items").children("div").size() > 1) {
                $(this).parent().parent().parent().remove();
            }
            if ($("#items").children("div").size() == 1) {
                $("#items").find("button").attr("disabled", true);
            }
            builderIndex();
            calculateWorkload();
        }
    );

    $(".rate").change(
        function () {
            calculateWorkload();
        }
    );
    $(".workload").change(
        function(){
            calculateTotalWorkload();
        }
    );
    $("#workload\\.stuNumbers").change(function () {
        if (!isNumber($("#workload\\.weekNumbers").val())) {
            alert("请输入实践周数!");
            $("#workload\\.weekNumbers").focus();
            return;
        }
        var weekNumbers = parseFloat($("#workload\\.weekNumbers").val());
        var stuNumbers = parseInt($("#workload\\.stuNumbers").val());
        var classNumbers;
        if (stuNumbers < 20) {
            classNumbers = Number(stuNumbers / 35);
        } else if(stuNumbers < 35) {
            classNumbers = 1;
        } else {
            classNumbers = Number(stuNumbers / 35);
        }
        $("#workload\\.classNumbers").val(classNumbers.toFixed(2));
        $("#workload\\.totalWorkload").val(fixed2(weekNumbers*classNumbers*22));
    });
});// JavaScript Document

function builderIndex(){
	$.each($("#items").children(),function(i,val){
		$("#items").children("div").eq(i).children().eq(0).find("input").attr("name","items["+i+"].teacherSn");
		$("#items").children("div").eq(i).children().eq(0).find("input[type=hidden]").eq(0).attr("name","items["+i+"].id");
		$("#items").children("div").eq(i).children().eq(0).find("input[type=hidden]").eq(1).attr("name","items["+i+"].practiceWorkloadId");
		$("#items").children("div").eq(i).children().eq(1).find("input").attr("name","items["+i+"].teacherWorkloadRate");
		$("#items").children("div").eq(i).children().eq(2).find("input").attr("name","items["+i+"].teacherWorkload");
				
	});	
}

function calculateWorkload(){
	var totals=0;
    var totalWorkload = $("#workload\\.totalWorkload").val();
    var workload = 0;
    $.each($(".rate"),function(i,val){
        var rate = parseInt($(this).val());
        if(rate!=0) {
            workload = rate * 0.01 * totalWorkload;
            $(".workload").eq(i).val(fixed2(workload));
            totals+=workload;
        } else {
            totals += Number($(".workload").eq(i).val());
        }
    });
	$("#totalWorkload").val(fixed2(totals));
}

function calculateTotalWorkload() {
	var totals = 0;
	$.each($(".rate"),function() {
		$(this).val(0);
    });
    $.each($(".workload"),function(){
        totals+=parseFloat($(this).val());
    });
    $("#totalWorkload").val(fixed2(totals));
}

//数值保留2位小数
function fixed2(obj) {
    return Number(obj).toFixed(2);
}

function validate_rate(){
    var flag = 0;
	$.each($(".rate"),function(){
		if(!isNumber($(this).val())){
			alert("请输入数值比例");
			$(this).focus();
			flag=1;
		}
	});

	if(flag) return false;
	else return true;
}

function validate_workload(){
    var flag = 0;
    $.each($(".workload"),function(){
        if(!isNumber($(this).val())){
            alert("请输入数值比例");
            $(this).focus();
            flag=1;
        }
    });
    if(flag) return false;
    else return true;
}

function validate_total_workload() {
    // 首先保留两位小数
    var workload1 = parseFloat($("#totalWorkload").val()).toFixed(2);
    var workload2 = parseFloat($("#workload\\.totalWorkload").val()).toFixed(2);
// 两位小数， 如果相减的绝对值 > 0.001, 那么这两个值一定不相等
    if(Math.abs(workload1 - workload2) > 0.001 ){
    	alert("工作了核对有误，请重新输入!")
        return false;
    } else {
		return true;
    }
}

function validate_add_form() {
	if( validate_rate() && validate_workload() && validate_total_workload()) {
		return true;
	} else {
		return false;
	}
}

//判断字符是否为空的方法
function isEmpty(obj){
	if(typeof obj == "undefined" || obj == null || obj == ""){
		return true;
	}else{
		return false;
	}
}

function isNumber(value) {
	var patrn = /^(-)?\d+(\.\d+)?$/;
	if (patrn.exec(value) == null || value == "") {
		return false
	} else {
		return true
	}
}

