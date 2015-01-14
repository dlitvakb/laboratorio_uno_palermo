var Issues = {};

Issues.load_list = function(url, callback, container_id, add_delete, clear) {
  add_delete = (add_delete !== undefined) ? add_delete : true;
  clear = (clear !== undefined) ? clear : true;
  Issues.get(url, function(data) {
    var container = (container_id != undefined)? container_id : "#results-table";
    if (clear)
      $(container).html('');
    $.each(data['data'], function(i, e) {
      callback(e);
    });

    if (add_delete)
      Issues.add_delete(container);
  });
}

Issues.get_list = function(url, callback, after_callback) {
  Issues.get(url, function (data) {
    $.each(data['data'], function (i, e) {
      callback(e);
    });
  });

  if (after_callback !== undefined) {
    after_callback();
  }
}

Issues.get = function(url, callback) {
  $.ajax({
    url: url,
    type: 'GET',
    accept: 'application/json',
    dataType: 'json',
    success: callback
  });
}

Issues.post = function(url, data, callback, errback) {
  $.ajax({
    type: 'POST',
    url: url,
    data: JSON.stringify(data),
    success: callback,
    error: errback,
    dataType: 'json',
    contentType: 'application/json'
  });
}

Issues.put = function(url, data, callback, errback) {
  $.ajax({
    type: 'PUT',
    url: url,
    data: JSON.stringify(data),
    success: callback,
    error: errback,
    dataType: 'json',
    contentType: 'application/json'
  });
}

Issues.delete = function(url, callback, errback) {
  $.ajax({
    type: 'DELETE',
    url: url,
    success: callback,
    error: errback,
    dataType: 'json',
    contentType: 'application/json'
  });
}

Issues.add_delete = function(container) {
  $(container + ' a.issues-delete').on('click', function() {
    var url = $(this).data('url');
    var display = $(this).data('display');

    if (window.confirm('Are you sure you want to delete: ' + display + '?')) {
      $(this).closest('tr').remove();
      Issues.delete(url, function() {
        console.log('deleted' + display);
      });
    }
  });
}

Issues.load_foreign_key = function(url, container, callback) {
  Issues.load_list(url, function(e) {
    $(container).append("<option value='" + e['id'] + "'>" + callback(e) + "</option>");
  }, container, false, false);
}
