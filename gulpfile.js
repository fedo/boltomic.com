var gulp = require('gulp');
var ftp = require('vinyl-ftp');
var gutil = require('gulp-util');
var minimist = require('minimist');
var args = minimist(process.argv);
var sass = require('gulp-sass');
var gulpif = require('gulp-if');
var notify = require('gulp-notify');
var gulpSize = require('gulp-size');
var autoprefixer = require('gulp-autoprefixer');


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


gulp.task('sass', function(){
    var sassPath = './resources/sass/style.scss';
    var dest_path    = './resources/public/';
    gulp.src(sassPath)
        .pipe(sass())
        .on('error', notify.onError(function(error) {
            return 'SASS error compile: ' + error.message + ' on line ' + error.lineNumber + ' in file ' + error.fileName;
        }))
        //.pipe(autoprefixer({
        //    browsers: ['last 3 versions'],
        //    cascade: false
        //}))
        //.on('error', notify.onError(function(error) {
        //    return 'autoprefixer error compile: ' + error;
        //}))
        .pipe(gulp.dest(dest_path + '/css'))
        .pipe(gulpSize({title: 'sass'}))
});
