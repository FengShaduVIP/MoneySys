var id = T.p("id");
var vm = new Vue({
	el:'#rrapp',
	data:{
		title:"新增",
		project:{}
	},
	created: function() {
		if(id != null){
			this.title = "修改";
			this.getInfo(id)
		}
    },
	methods: {
		getInfo: function(id){
			$.get("../project/info/"+id, function(r){
                vm.project = r.project;
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.project.id == null ? "../project/save" : "../project/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.project),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.back();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		back: function (event) {
			history.go(-1);
		}
	}
});