var gulp = require('gulp');
var ftp = require('vinyl-ftp');
var gutil = require('gulp-util');
var minimist = require('minimist');
var args = minimist(process.argv.slice(2));

gutil.log("environment = " + args.environment);

var host = '';
var user = '';
var password = '';
var remotePath = '';

gulp.task('deploy', function() {
    var conn = ftp.create({
        host: host,
        user: user,
        password: password,
        parallel: 3,
        log: gutil.log
    });

    gulp.src(['resources/public/**'])
        .pipe(conn.newer(remotePath))
        .pipe(conn.dest(remotePath));
});