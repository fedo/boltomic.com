var argv = require('yargs').argv;
var autoprefixer = require('gulp-autoprefixer');
var ftp = require('vinyl-ftp');
var gulp = require('gulp');
var gulpSize = require('gulp-size');
var gutil = require('gulp-util');
var minimist = require('minimist');
var notify = require('gulp-notify');
var sass = require('gulp-sass');
var sourcemaps = require('gulp-sourcemaps');


var sassPath = './resources/sass/*.scss';
var destPath = './resources/public/css';


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


gulp.task('sass', function () {
    return gulp.src(sassPath)
        .pipe(sourcemaps.init())
        .pipe(sass({outputStyle: 'compressed'}))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(destPath).on('error', sass.logError))
        .pipe(gulpSize({title: 'sass'}))
});
