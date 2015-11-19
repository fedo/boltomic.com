var gulp = require('gulp');
var ftp = require('vinyl-ftp');
var gutil = require('gulp-util');
var minimist = require('minimist');
var args = minimist(process.argv.slice(2));

gulp.task('deploy', function () {
    var remotePath = "/",
        conn = ftp.create({
            host: args.host,
            user: args.user,
            password: args.password,
            parallel: 3,
            log: gutil.log
        });

    gulp.src(['resources/public/**'])
        .pipe(conn.newerOrDifferentSize(remotePath))
        .pipe(conn.dest(remotePath));
});