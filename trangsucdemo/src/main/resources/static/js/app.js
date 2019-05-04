/*Ext.onReady(function() {
	Ext.application({
		name : 'Fiddle',

		launch : function() {
			$('#table').excelTableFilter({
				columnSelector : '.filter', // (optional) if present, will only
											// select <th> with specified class
				sort : true, // (optional) default true
				search : false
			// (optional) default { a_to_z: 'A to Z', z_to_a: 'Z to A', search:
			// 'Search', select_all: 'Select All' }
			});
		}
	});
});*/
$( document ).ready(function() {
	$('#table').excelTableFilter({
		columnSelector : '.filter', // (optional) if present, will only
									// select <th> with specified class
		sort : false, // (optional) default true
		search : false
	// (optional) default { a_to_z: 'A to Z', z_to_a: 'Z to A', search:
	// 'Search', select_all: 'Select All' }
	});
});