define([ "jquery", "tree", "table", "menu" ], function($, tree, table, menu) {

	var initTree = function() {
		tree.asyncTree({
			treeName : "#modulePanel #configTree",
			url : "/config-restful/property/tree",
			onClick : function(event, treeId, treeNode) {
				if (treeNode.isModule) return;
				nodePanel(treeNode);
			},
			onRightClick : function(event, treeId, treeNode) {
				if (!treeNode.isModule) return;
				nodePanel(treeNode);
			},
			onExpand : function(event, treeId, treeNode) {
				initzTreeRightMenu(treeNode.tId);
			}
		});
	};

	var nodePanel = function(treeNode) {
		$.ajax({
			url : "/config-restful/property/node/" + treeNode.id,
			type : "GET",
			success : function(response) {
				var header = response.header;
				if (header.statusCode != 200) {
					console.error(header.message);
					return;
				}
				var property = response.body;
			}
		});
	};

	/* 以下方法是通过上面的js插件封装的方法 */

	/*
	　　parentNode（zTree容器 || 指定的节点）
	*/
	function initzTreeRightMenu(treeId) {
		//树形菜单右击事件
		$('li, a', $(treeId)).contextmenu({
			target : '#zTreeRightMenuContainer', //此设置项是zTree的容器
			before : function(e, element, target) {
				var zTreeObj = $.fn.zTree.getZTreeObj("configTree");
				//当前右击节点ID
				var selectedId = element[0].tagName == 'LI' ? element.attr('id') : element.parent().attr('id');
				//根据节点ID获取当前节点详细信息
				curSelectNode = zTreeObj.getNodeByTId(selectedId);
				//当前节点的层级
				var level = curSelectNode.level;
				level = 0;
				//选中当前右击节点
				zTreeObj.selectNode(curSelectNode);
				//根据当前节点层级显示相应的菜单
				$('#zTreeRightMenuContainer ul.dropdown-menu[level="' + level + '"]').removeClass('hide').siblings().addClass('hide');
			},
			onItem : function(context, e) {
				var action = $(e.target).attr('action');
				this.closemenu();
				if (action) {
					zTreeRightMenuFuns[action]();
				}
			}
		});
	}

	var initTable = function() {
		$("#configPanel #configTable").bootstrapTable({
			//			url : '/Home/GetDepartment', //请求后台的URL（*）
			method : 'get', //请求方式（*）
			toolbar : '#toolbar', //工具按钮用哪个容器
			striped : true, //是否显示行间隔色
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, //是否显示分页（*）
			sortable : false, //是否启用排序
			sortOrder : "asc", //排序方式
			//  queryParams: oTableInit.queryParams,//传递参数（*）
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, //初始化加载第一页，默认第一页
			pageSize : 10, //每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
			search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,
			showColumns : true, //是否显示所有的列
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行
			height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "ID", //每一行的唯一标识，一般为主键列
			showToggle : true, //是否显示详细视图和列表视图的切换按钮
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'Name',
				title : '部门名称'
			}, {
				field : 'ParentName',
				title : '上级部门'
			}, {
				field : 'Level',
				title : '部门级别'
			}, {
				field : 'Desc',
				title : '描述'
			}, ]
		});
	};

	return {
		onload : function() {
			initTree();
		//			initTable();
		}
	}

});