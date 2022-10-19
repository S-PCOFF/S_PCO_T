var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        // work
        $('#btn-work-save').on('click', function () {
            _this.work_save();
        });

        $('#btn-work-update').on('click', function () {
            _this.work_update();
        });

        $('#btn-work-delete').on('click', function () {
            _this.work_delete();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    work_save : function () {
            var data = {
                id: $('#id').val(),
                name: $('#name').val(),
                workDate: $('#workDate').val(),
                workMinute: $('#workMinute').val()
            };

            $.ajax({
                type: 'POST',
                url: '/api/v1/work',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('근무가 등록되었습니다.');
                window.location.href = '/work';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },
    work_update : function () {
            var data = {
                name: $('#name').val(),
                workDate: $('#workDate').val(),
                workMinute: $('#workMinute').val()
            };

            var idx = $('#idx').val();

            $.ajax({
                type: 'PUT',
                url: '/api/v1/work/'+idx,
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('근무가 수정되었습니다.');
                window.location.href = '/work';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },
    work_delete : function () {
            var idx = $('#idx').val();

            $.ajax({
                type: 'DELETE',
                url: '/api/v1/work/'+idx,
                dataType: 'json',
                contentType:'application/json; charset=utf-8'
            }).done(function() {
                alert('근무가 삭제되었습니다.');
                window.location.href = '/work';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
};

main.init();