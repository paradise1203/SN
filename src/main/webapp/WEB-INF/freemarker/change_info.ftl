<div class="container">
    <div>
        <form role="form">
            <div class="form-group">
                <label for="fName">First name: </label>
                <input id="fName" class="form-control" type="text" value=${user.firstName}>
            </div>
            <div class="form-group">
                <label for="lName">Last name: </label>
                <input id="lName" class="form-control" type="text" value=${user.lastName}>
            </div>
            <div class="form-group">
                <label for="sex">Sex: </label>
                <select id="sex" name="sex">
                    <option value=0> Male </option>
                    <option value=1> Female </option>
                </select>
            </div>
            <div class="form-group">
                <label for="city">City: </label>
                <input id="city" class="form-control" type="text" value=${user.city}>
            </div>
            <div class="form-group">
                <label for="mobile">Mobile: </label>
                <input id="mobile" class="form-control" type="text" value=${user.mobilePhone}>
            </div>
            <input type="button" class="btn btn-success changeInfo" value="send">
        </form>
    </div>
</div>