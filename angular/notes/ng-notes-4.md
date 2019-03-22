# Adding Bootstrap to Angular Applications

There are a few ways that we can include the Bootstrap libraries into our nG applications. The first and most obvious way would be to include the Bootstrap CDN links within the head element of the project's `index.html` file.

However, in nG applications we can download Bootstrap as a dependency using NPM. To do so, execute the following command in the root directory of the project:

    npm install bootstrap --save

The `--save` flag adds Bootstrap as a dependency in the project's `package.json` file. You can find it within the `dependencies` array. The version installed (at the time of this writing) is `^4.1.0`. This version number is broken up into three numbers: major, minor, and patch. The karat symbol before the major version number indicates that our application can use all versions up to this major version. So, when Bootstrap v4.2.0 is released, our application will automatically use it - even without us updating the `package.json`.

In `styles.css` we need to include an import that allows us to apply the Bootstrap styles globally across our entire application.


## ng-boostrap

As an alternative to the above method of using Bootstrap, you can also leverage ng-bootstrap. ng-bootstrap is a set of components and directives that wrap up the latest version of Bootstrap. This makes it easy to use Bootstrap in our nG applications. In order to install ng-bootstrap, execute the following command:

    npm install --save @ng-bootstrap/ng-bootstrap @4.1.0

Once the installation is complete, we need to include the styles inside of the styles array found inside of our `.angular-cli.json` file. Include the following style in the array:

    "../node_modules/bootstrap/dist/css/bootstrap.min.css"

This will take care of adding the CSS dependencies for Bootstrap. You may need to restart the dev server in order for these changes to take effect.