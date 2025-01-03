window.onload = () => {
	const form = document.querySelector("form");
	const modal = document.getElementById("modal");
	const button = document.getElementById("btn");

	const userName = document.getElementById("userName");
	const identity = document.getElementById("identity");
	const phoneNo = document.getElementById("phoneNo");
	const loginTypeLevel = document.getElementById("loginTypeLevel");
	const telecom = document.getElementById("telecom");
	
	const path = document.getElementById("path");

	form.addEventListener("submit", async (e) => {
		e.preventDefault();

		modal.style.display = "flex";

		const data = {
			"userName": userName.value,
			"identity": identity.value,
			"phoneNo": phoneNo.value,
			"loginTypeLevel": loginTypeLevel.value,
			"telecom": telecom.value
		}

		const response = await fetch(`${path.value}/service`, {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(data)
		});

		const auth = await response.json();

		setTimeout(() => {
			console.log("CHECK");
			button.addEventListener("click", async (e) => {
				const mfaData = {
					"data": data,
					"auth": auth
				}

				const res = await fetch(`${path.value}/mfa`, {
					method: "POST",
					headers: {
						"Content-Type": "application/json"
					},
					body: JSON.stringify(mfaData)
				});

				const resData = await res.json();

				modal.style.display = "none";
				document.open();
				document.write("<pre>" + JSON.stringify(resData.data, null, 2) + "</pre>");
			}, { once: true });
		}, 3000);
	});


}