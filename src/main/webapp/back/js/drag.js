/*$(function() {
	$(".demo").draggable({
		connectToSortable: ".user-demo",
		helper: "clone",
		handle: ".demo-drag",
		start: start,
		stop: function() {
			$(".demo .column").sortable({
				opacity: .35,
				connectWith: ".demo .column"

			}).disableSelection();
		}

	});
	$(".user-demo").sortable();
});

function start(e, t) {
	t.helper.find('.view').removeClass('view');
	t.helper.find('.demo-name').css("display", "none");
	//console.log(t.helper[0].lastElementChild)
	//t.helper.find('.demo-name').css("display", "none");
	//t.helper[0].lastElementChild.removeClass('view');
}*/

$(document).ready(function() {
	"use strict";
	//本地化
	$(".user-demo").html(localStorage.html);


	$(".left-nav a[data-toggle=collapse]").click(function(e) {
		e.preventDefault();
		$(this).parent().siblings().removeClass("active");
		$(this).parent().siblings().find('.collapse').removeClass("in");
		$(this).parent().addClass("active");
		saveLayout();
	});
	//初始化Editor
	var editor = UE.getEditor('myEditor');
	/*	$(".user-demo").delegate(".edit", "click", function(e) {
			//初始化编辑器
			e.preventDefault();
			//UM.getEditor('myEditor').setWidth(document.body.clientWidth - 200);
			var source = //'<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">' +
				//'<script type="text/javascript" src="./js/jquery.min.js"></'+'script>'+
				'<script type="text/javascript" src="./js/bootstrap.min.js"></' + 'script>';
			'';
			var view = $(this).siblings(".view").html();
			//var body = $("<div>" + source + "<div class='outHtml'>" + view + "</div></div>").html();
			editor.ready(function() {
				//if (editor.queryCommandState('source')) {
				//	editor.execCommand('source');
				//}
				$('.editor').addClass("showeditor");
				editor.setContent("");
				editor.setContent($.trim(view));
				//editor.execCommand('source');
				//editor.execCommand('source');
				//editor.execCommand( 'undo' );
			})


			$(".editor").delegate(".save", "click", function(e) {
				e.preventDefault();
				//var outHtml = $(".outHtml").html();
				var html = $(this).siblings(".view");
				html.empty();
				html.append(editor.getContent());
				$('.editor').removeClass("showeditor");

			}).bind(this);
		});*/
	//编辑器操作
	var self = null;
	$(".user-demo").delegate(".edit", "click", function(e) {
		e.preventDefault();
		if (editor.queryCommandState('source') == 1) {
			editor.execCommand('source');
		}
		var view = $(this).siblings(".view").html();
		//editor.setContent("");
		var html = "<div class='outHtml'>" + view + "</div>";
		editor.setContent(html);
		$(".editor").addClass("showeditor");
		self = this;
		saveLayout();
	});
	$(".editor").delegate(".save", "click", function(e) {
		e.preventDefault();
		$(self).siblings(".view").empty().append(editor.body.children[0].children);
		$(".editor").removeClass("showeditor");
	});

	//按钮编辑操作
	var self2;
    var rel = '';
    var newClass = '';
    var oldClass='';
	$(".user-demo").delegate(".btn-edit", "click", function(e) {
		e.preventDefault();
		var btn = $(this).siblings(".view").children("button")[0];
		var btnEle = $(this).siblings(".view").children();
		$(".btn-editor").empty();
		$(".btn-editor").append('<form class="btn-form"></form>' +
			'<button class="btn-save btn btn-success">保存</button>' +
			'<button class="btn-close btn btn-danger">关闭</button>');
		var form = $(".btn-form");
		insertHtml("button", form);
		setInputValue("button", form, btn);

		$(".btn-editor").removeClass("off").addClass("on");

        $('.btn-drop-menu a').click(function () {
            rel = '';
            $('.btn-drop-menu a').each(function () {
                rel += $(this).attr('rel') + ' ';
            });

            newClass = $(this).attr('rel');
			btnEle.removeClass(rel);
            oldClass = btnEle.attr('class');
		 	btnEle.addClass($(this).attr('rel'));
        });

		self2 = this;
		$(".btn-save").click(function(e) {
			var btn = $(self2).siblings(".view").find("button")[0];
			var form = $(".btn-form")
			setElementProperty("button", btn, form, self2);
		});
		$(".btn-close").click(function() {
			$(".btn-editor").removeClass("on").addClass("off");
		});
		saveLayout();

	});

	//输入框编辑操作
	$(".user-demo").delegate(".input-edit", "click", function(e) {

		e.preventDefault();
		var input = $(this).siblings(".view").children("input")[0];
		$(".btn-editor").empty();
		$(".btn-editor").append('<form class="btn-form"></form><button class="input-save btn btn-success">保存</button>' +
			'<button class="input-close btn btn-danger">关闭</button>');
		var form = $(".btn-form");
		insertHtml("input", form);
		setInputValue("input", form, input);

		$(".btn-editor").removeClass("off").addClass("on");
		self2 = this;
		$(".input-save").click(function(e) {
			var input = $(self2).siblings(".view").find("input")[0];
			var form = $(".btn-form")
			setElementProperty("input", input, form, self2);

		});
		$(".input-close").click(function() {
			$(".btn-editor").removeClass("on").addClass("off");
		});
		saveLayout();
	});

	//编辑单选框操作
    $(".user-demo").delegate(".radio-edit", "click", function(e) {

        e.preventDefault();
        var radio = $(this).siblings(".view").children(".radio")[0];
        var i = $(radio).find('label').length;
        $.each($(radio).find("label"), function (index, label) {
            $(this).data("id", index);
        });
        $(radio).data("required", false);
        $(radio).data("other-select", false);
        $(radio).data("columns", '0');

        $(".btn-editor").empty();
        $(".btn-editor").append('<form class="btn-form"></form>' +
			'<button class="input-save btn btn-success">保存</button>' +
            '<button class="input-close btn btn-danger">关闭</button>');
        var form = $(".btn-form");
        insertHtml("radio", form, radio);
        setInputValue("radio", form, radio);

        $(".btn-editor").removeClass("off").addClass("on");
        self2 = this;
        $(".add-radio").click(function (e) {
        	e.preventDefault();
            $(self2).siblings(".view").children(".radio").append("<label class='i-checks' data-id='"+ i +"'> <input type='radio' name='a' value='option1'><i></i>选项"+(i+1)+"</label>");
			form.find('.content-select').append('<div><input type="text" value="选项' + (i+1) +'" class="form-control content-text"><span class="glyphicon glyphicon-remove radio-remove" data-id="'+ i +'" aria-hidden="true"></span></div>');
            i++;
        });

        $(document).on("click", ".radio-remove", function () {
        	var remove_index = $(this).data('id');
        	$.each($(radio).find("label"), function () {
        		var label_index = $(this).data("id");
				if(label_index == remove_index){
					$(this).remove();
				}
            });
			$(this).parent("div").remove();
        });

        $(".input-save").click(function(e) {
            var radio = $(self2).siblings(".view").find(".radio")[0];
            var form = $(".btn-form");
            setElementProperty("radio", radio, form, self2);

        });
        $(".input-close").click(function() {
            $(".btn-editor").removeClass("on").addClass("off");
        });
        saveLayout();
	});


	//自定义编辑器配置
	var config = {
		button: {
			id: "id标识",
			// className: "样式",
			innerText: "按钮文字"
		},
		input: {
			id: "id标识",
			name: "名字",
			placeholder: "默认站位值"
		},
		radio:{
			id: "id标识",
			title: "标题"
		}
	};

	function insertHtml(pro, pos, ele) {
		var property = config[pro];
		var html = "";
		pos.empty();
		for (var key in property) {
			html += '<div class="form-group">' +
				'<label for="' + key + '">' + property[key] + '</label>' +
				'<input type="text" class="form-control" id="' + key + '">' +
				'</div>';
		}
		if (pro === "button") {
			html += '<div class="form-group">' +
				'<label for="iconStyle">icon样式</label>' +
				'<input type="text" class="form-control" id="iconStyle">' +
				'</div>' +
				'<div class="form-group">' +
                '<label>样式</label>'+
				'<ul class="btn-drop-menu">' +
				'<li><a href="#" style="color: #fff" rel="btn-default">默认</li>' +
				'<li><a href="#" style="color: #fff" rel="btn-primary">原生</li>' +
				'<li><a href="#" style="color: #fff" rel="btn-success">成功</li>' +
				'<li><a href="#" style="color: #fff" rel="btn-warning">警告</li>' +
				'</ul>'+
				'</div>';
		}
		if (pro === "input") {
			html += '<div class="form-group">' +
				'<label for="type">类型</label>' +
				'<select style="color:black">' +
				'<option value="text">text</option>' +
				'<option value="number">number</option>' +
				'<option value="email">email</option>' +
				'<option value="date">date</option>' +
				'<option value="file">file</option>' +
				'</select>' +
				'</div>';
			html += '<div class="radio">' +
				'<label for="disabled">是否禁用</label>' +
				'<label class="radio-inline"><input type="radio" name="disabled" value="true">是</label>' +
				'<label class="radio-inline"><input type="radio" name="disabled" value="false">否</label>' +
				'</div>';
			html += '<div class="form-group">' +
				'<label for="label">label值</label>' +
				'<input type="text" class="form-control" id="label">' +
				'</div>';
		}
		if(pro == "radio"){
            html += '<div class="form-group">' +
				'<input type="checkbox" id="is-mast">' +
				'<label for="is-mast">是否必填</label>' +
				'</div>' +
				'<div class="form-group content-select">' +
				'<label for="type">类容选项</label>';
            for(var i = 0;i<$(ele).find('label').length;i++){
                html += '<div><input type="text" placeholder="选项1" class="form-control content-text"><span class="glyphicon glyphicon-remove radio-remove" data-id="'+ i +'" aria-hidden="true"></span></div>';
            }
            html += '</div>' +
                '<div class="form-group">' +
                '<button class="btn btn-default add-radio" style="width: 100%;"><i class="fa fa-plus"></i>添加选项</button></div>' +
				'<div class="form-group">' +
				'<input type="checkbox" id="others">' +
				'<label for="others">添加'+"'其他'"+'选项</label>' +
                '</div>';
           /* html += '<div class="form-group">' +
                '<label for="label">选项列数</label>' +
				'<ul class="columns-select">' +
				'<li class="active">一列</li>' +
				'<li>两列</li>' +
				'<li>三列</li>' +
				'<li>四列</li>' +
				'</ul>' +
                '</div>';*/
		}
		pos.append(html);
	}
	// pro 所要获取属性的元素类型; element:所要设置的元素 
	function getElementProperty(pro, element) {
		var property = config[pro];
		var val = {},
			key;
		val["option"] = [];
		for (key in property) {
			val[key] = element[key];
		}
		if (pro === "button" && element.children[0]) {
			val["iconStyle"] = element.children[0].className || '';
		}
		if (pro === "input") {
			val["disabled"] = element.disabled;
			val["type"] = element.type;
			val["label"] = $(element).siblings().text();
		}
		if(pro === "radio") {
			val["title"] = $(element).find('p').text();
			val["required"] = $(element).data("required");
            $(element).find('label').each(function () {
            	val["option"].push($.trim($(this).text()));
            });
            val["otherSelect"] = $(element).data("other-select");
            val["columns"] = $(element).data("columns");
		}
		return val;
	}

    //step1:设置编辑器中input输入值
    function setInputValue(pro, form, element) {
        var i = 0;
        var val = getElementProperty(pro, element);
        var property = config[pro];
        for (var key in property) {
            form.find("input#" + key)[0].value = val[key];
        }
        if (pro === "button" && val["iconStyle"]) {
            form.find("input#iconStyle")[0].value = val["iconStyle"];
        }
        if (pro === "input") {
            form.find("input[value=" + element.disabled + "]")[0].checked = true;
            // val["disabled"] = element.disabled;
            form.find("select")[0].value = element.type;
            // val["type"] = element.type;
            form.find("#label").val(val["label"]);
        }
        if(pro === "radio"){
			form.find("input[id=is-mast]").prop("checked", val["required"]);
            form.find(".content-text").each(function () {
                $(this).val(val.option[i]);
                i++;
            });
			form.find("input[id=others]").prop("checked", val["other-select"]);
			form.find("ul[class=columns-select] li").eq(parseInt(val["columns"])).addClass("active").siblings().removeClass("active");
        }
    };
	//step2. pro 所要获取属性的元素类型; element:所要设置的元素; val: 所要设置的值
	function setElementProperty(pro, element, form, self) {
		var val = getInputValue(pro, form);
		var property = config[pro];
		for (var key in property) {
			element[key] = val[key];
		}
		if (pro === "button" && val["iconStyle"]) {
			var iconstyle = val["iconStyle"].split(" ");
			$(self).siblings(".view").find("button").addClass("btn-addon btn-sm").removeClass("w-xs").append($('<i></i>'))
			for (var i = 0; i < iconstyle.length; i++) {
				$(self).siblings(".view").find("i").addClass(iconstyle[i]);
			}
		}
		if (pro === "input") {
			$(self).siblings(".view").children("input").attr("disabled", val["disabled"]);
			element.type = val["type"];
			$(element).siblings().text(val["label"]);
		}
		if (pro === "radio"){
            $(self).siblings(".view").find("p").text(val["title"]);
            $.each($(element).find('label'), function (index) {
            	var content = val["option"][index];
				$(this).html('<input type="radio" name="a" value="option1"><i></i> ' + content + '');
            });
            if(val["otherSelect"] == true){
            	$(element).append('<label class="i-checks" class="others"> <input type="radio" name="a" value="option1"> <i></i>其它</label>')
			}else{
            	$(element).find('.others').remove();
			}
		}
	};



	//获取编辑器中input输入值
	function getInputValue(pro, form) {
		var property = config[pro];
		var val = {};
		val["option"] = [];
		for (var key in property) {
		    if(key == 'className'){
                val[key] = oldClass + ' ' + newClass;
            }else{
                val[key] = form.find("input#" + key)[0].value || '';
            }
		}
		if (pro === "button" && form.find("input#iconStyle")[0].value) {
			val["iconStyle"] = form.find("input#iconStyle")[0].value;
		}
		if (pro === "input") {
			val["disabled"] = form.find('input[value="true"]')[0].checked;
			val["type"] = form.find("select option:selected")[0].value;
			val["label"] = form.find("#label").val();
		}
		if (pro === "radio") {
			val["columns"] = '0';
			val["otherSelect"] = form.find("input[id=others]")[0].checked;
			val["required"] = form.find("input[id=is-mast]")[0].checked;
			$.each(form.find(".content-text"), function (index, item) {
				val["option"].push($(item).val());
            });
		}
		return val;
	}

	//导航active 初始化
	$("body").delegate("#head-bar>ul>li", "click", function(e) {
		$(this).siblings().removeClass("active");
		$(this).addClass("active");
		saveLayout();
	})

	//编辑、预览模式切换事件
	$(".nav").delegate("#preview", "click", function(e) {

		$(".left-nav").addClass("hide-left-nav");
		$("body").css("padding-left", "0").addClass("sourcepreview").removeClass("editview");

		/*($(".user-demo .column,.user-demo .demo .row-fluid, .box").each(function() {
			$(this).removeClass("column").removeClass("row-fluid").removeClass("box");
		}).bind(this));*/
		//隐藏编辑，删除等按钮
		$(".user-demo .demo").children().not($('.view ,.demo-name')).css("display", "none");
	});
	$("#emptyHTML").click(function(){
		$(".user-demo").html('');
	})

	$(".nav").delegate("#edit", "click", function(e) {

		$(".left-nav").removeClass("hide-left-nav");
		$("body").css("padding-left", "210px").removeClass("sourcepreview").addClass("editview");
		$(".user-demo .demo").children().not($('.view ,.demo-name')).css("display", "block");

	});

	$(".user-demo").delegate(".remove", "click", function(e) {

		e.preventDefault();
		$(this).parent().remove();
		saveLayout();

	});
	$(".left-nav .grid").draggable({
		connectToSortable: ".user-demo",
		helper: "clone",
		handle: ".demo-drag",
		start: function(e, t) {


		},
		drag: function(e, t) {
			t.helper.width(400);
		},
		stop: function(e, t) {
			$(".user-demo .column").sortable({
				opacity: .35,
				connectWith: ".column",
				placeholder: "placeholder",
				start: function(e, t) {

				},
				stop: function(e, t) {
					saveLayout();
				}
			});

		}
	});
	$(".left-nav .ele").draggable({
		connectToSortable: ".column",
		helper: "clone",
		handle: ".demo-drag",
		start: function(e, t) {

		},
		drag: function(e, t) {
			t.helper.width(400);
		},
		stop: function(e, t) {
			handleModalIds();
			handleCarouselIds();
			saveLayout();
		}
	});
	$(".user-demo, .user-demo .column").sortable({
		connectWith: ".column",
		opacity: .35,
		handle: ".demo-drag",
		placeholder: "placeholder",

	});

	function randomNumber() {
		return randomFromInterval(1, 1e6)
	}

	function randomFromInterval(e, t) {
		return Math.floor(Math.random() * (t - e + 1) + e)
	}

	function handleModalIds() {
		var e = $(".user-demo .demo .view #myModal");
		var t = randomNumber();
		var n = "modal-container-" + t;
		var r = "modal-" + t;
		e.attr("id", r);
		e.attr("data-target", "#" + n);
		e.next().attr("id", n)
	}

	function handleCarouselIds() {
		var e = $(".user-demo .demo .view #myCarousel");
		var t = randomNumber();
		var n = "carousel-" + t;
		e.attr("id", n);
		e.find(".carousel-indicators li").each(function(e, t) {
			$(t).attr("data-target", "#" + n)
		});
		e.find(".left").attr("href", "#" + n);
		e.find(".right").attr("href", "#" + n)
	}

	//生成html
	function cleanHtml(e) {
		$(e).parent().append($(e).children().html());
	}

	function createHTML() {
		var html = $(".user-demo").children().clone();
		html.find(".demo-drag,.demo-name,.remove,.edit,.input-edit").remove();
		//嵌套的row层数为5时
		html.find(".grid .grid .grid .grid .grid .demo").each(function() {
			cleanHtml(this)
		});
		html.find(".grid .grid .grid .grid .demo").each(function() {
			cleanHtml(this)
		});
		html.find(".grid .grid .grid .demo").each(function() {
			cleanHtml(this)
		});
		html.find(".grid .grid .demo").each(function() {
			cleanHtml(this)
		});
		html.find(".grid .demo").each(function() {
			cleanHtml(this)
		});
		html.find(".demo").each(function() {
			cleanHtml(this)
		});
		html.find(".demo").remove();
		html.find(".ui-sortable,.row-fluid,.clearfix").removeClass("ui-sortable row-fluid clearfix column");
		html.find(".view").removeClass("view").addClass("container-fluid");
		//格式化生成的html代码
		var formatSrc = $.htmlClean(html.html(), {
			format: true,
			allowedAttributes: [
				["id"],
				["class"],
				["placeholder"],
				["name"],
				["disable"],
				["data-toggle"],
				["data-target"],
				["data-parent"],
				["role"],
				["data-dismiss"],
				["aria-labelledby"],
				["aria-hidden"],
				["data-slide-to"],
				["data-slide"]
			]
		});
		return formatSrc;
	}
	$("#createHTML").click(function() {
		$(".dowloadHTML").find("textarea").val(createHTML());
		saveLayout();
	});

	//阻止demo中form submit提交行为
	$(".user-demo").delegate("form", "submit", function(e) {
		e.preventDefault();
	});

	//html5本地化
	var layouthistory;

	function supportstorage() {
		if (typeof window.localStorage == 'object')
			return true;
		else
			return false;
	}

	function saveLayout() {
		var data = localStorage.html;
		if (!data) {
			data = {};
		}
			data = $(".user-demo").html();
			if (supportstorage()) {
				localStorage.html = data;
			}

		layouthistory = data;
	}
});