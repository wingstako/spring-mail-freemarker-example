<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <style type="text/css">
        * {
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 0;
            margin: 0;
        }
        body {
            background-color: #b71540;
            font-family: 'Montserrat', sans-serif;
        }
        .box {
            background-color: transparent;
            border-radius: 3px;
            color: #fff;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 400px;
            height: 300px;
            transform-style: preserve-3d;
            perspective: 2000px;
            transition: 0.4s;
            text-align: center;
        }
        .box:before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: transparent;
            border-top: 20px solid #fff;
            border-left: 20px solid #fff;
            box-sizing: border-box;
        }
        .box:after {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            border-bottom: 20px solid #fff;
            border-right: 20px solid #fff;
            box-sizing: border-box;
        }
        .box .fas {
            font-size: 25px;
            height: 50px;
            width: 50px;
            line-height: 50px !important;
            background-color: #fff;
            color: #2c3a47;
        }
        .box .fa2 {
            position: absolute;
            bottom: 0;
            right: 0;
            z-index: 1;
        }
        .box .text {
            position: absolute;
            top: 30px;
            left: -30px;
            width: calc(100% + 60px);
            height: calc(100% - 60px);
            background-color: #2c3a47;
            border-radius: 3px;
            transition: 0.4s;
        }
        .box .text .fa1 {
            position: absolute;
            top: 0;
            left: 0;
        }
        .box .text div {
            position: absolute;
            top: 50%;
            left: 0;
            transform: translateY(-50%);
            text-align: center;
            width: 100%;
            padding: 30px 60px;
            line-height: 1.5;
            box-sizing: border-box;
        }
        .box .text div h3 {
            font-size: 30px;
            margin-bottom: 5px;
        }
        .box .text div p {
            font-size: 30px;
        }
        .box:hover {
            transform: translate(-50%, -50%) rotateY(-20deg) skewY(3deg);
        }
        .box:hover .text {
            transform: rotateY(20deg) skewY(-3deg);
        }

    </style>
</head>
<body>

    <div class="box"><i class="fas fa-quote-left fa2"></i>
        <div class="text"><i class="fas fa-quote-right fa1"></i>
          <div>
            <h3>Authentication Code</h3>
            <p>${verification.code}</p>
          </div>
        </div>
      </div>

</body>
</html>