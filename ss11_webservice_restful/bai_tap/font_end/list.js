function load(page, append) {
    $.ajax({
        type: "GET",
        url: 'http://localhost:8080/blog',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (data) {
            renderBlog(data, append);
            renderLoadMoreButton(data)
        },
        error: function (error) {
            console.log(error);
        }
    })
}

$(document).ready(() =>
    load()
)

function renderBlog(blog, append) {
    let element = "";
    for (let blogs of blog) {
        element +=
            `<div class="card col-sm-3">
                    <div class="card-body">
                       <h4 class="card-title">${blogs.title}</h4>
                       <p class="card-text">${blogs.author}</p>
                       <p class="card-text">${blogs.category}</p>
                    <a href="#" class="btn btn-primary">Add card</a>
                   </div>
                </div>`
    }
    if (append) {
        $("#listBlog").append(element)
    } else {
        $("#listBlog").html(element);
    }
}

function loadMore(nextPage) {
    load(nextPage, true);
}

function renderLoadMoreButton(blogPageData) {
    if (blogPageData.number < blogPageData.totalPages - 1) {
        $("#loadMoreContainer").html(
            `<button type="button" class="btn btn-primary" onclick="loadMore(${blogPageData.number + 1})">
            Load More
            </button>`
        )
    } else {
        $("#loadMoreContainer").remove();
    }
}
