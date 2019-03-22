# Create a Favorite Component

Using the nG CLI, create a component called `FavoriteComponent` that is rendered to the DOM as a star glyph icon. You will need to use some Bootstrap classes to properly render this icon: `glyphicon`, `glyphicon-star`, and `glyphicon-star-empty`. In order to have access to these you will need to include the following link within the head of the `index.html` file:

    <link data-require="bootstrap-css@3.3.6" data-semver="3.3.6" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css" />

Notice that we are using Bootstrap 3, instead of the new Bootstrap 4. This is because Bootstrap 4 got rid of the glyphicon library.

The way this component should work, is that it should start off as an empty star, and when clicked by the user it should toggle between empty and filled. Good luck!