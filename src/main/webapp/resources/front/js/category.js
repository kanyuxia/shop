var abc = [];

$(function(){
	
	//ѡ��filter�µ�����a��ǩ��Ϊ�����hover�������÷����������������ֱ���������Ϻ��ƿ���ִ�еĺ�����
	$("#filter a").hover(function(){
		$(this).addClass("seling");
	},function(){
		$(this).removeClass("seling");
	});

	//ѡ��filter�����е�dt��ǩ������Ϊdt��ǩ����ĵ�һ��dd��ǩ�µ�a��ǩ�����ʽseled��(��̾jquery��ǿ��)
	$("#filter dt+dd a").attr("class", "seled"); /*ע�⣺���Ӧ��������(attr)��ʽ�������������ʽ(addClass)��
	��Ȼ����ͨ��$("#filter a[class='seled']")���ʲ���class��ʽΪseled��a��ǩ��*/       

	//Ϊfilter�µ�����a��ǩ��ӵ����¼�
	$("#filter a").click(function(){
		$(this).parents("dl").children("dd").each(function(){
			$(this).children("div").children("a").removeClass("seled");
		});
	
		$(this).attr("class", "seled");
		var needhide = $(this);
		needhide.parentsUntil("dl").parent().hide();
		abc.push(needhide);
		var val = $(this).html().replace(/ /g, "kongge");
		var condition = '<a class="inbtn pzbtn" rel="'+$(this).html()+'"><span onclick=deleteC("'+val+'")>'+$(this).html()+'</span></a>';
		$("#condition").append(condition);
		// alert(RetSelecteds()); //����ѡ�н��
	});
// alert(RetSelecteds()); //����ѡ�н��
});

function deleteC(v){
	var val = v.replace(/kongge/g, " ");
	$("#condition").find("a[rel='"+val+"']").remove();
	for(var i = 0; i<abc.length; i++){
		if(abc[i].html() == val){
			abc[i].parentsUntil("dl").parent().show();
			abc.splice(i, 1);
			i--;
		}else{
			abc[i].parentsUntil("dl").parent().hide();
		}
	}
}

function RetSelecteds(){
	var result = "";
	$("#filter a[class='seled']").each(function(){
		result += $(this).html()+"\n";
	});
	return result;
}