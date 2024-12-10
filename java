// Interactive Menu
document.getElementById('toggleMenu').addEventListener('click', (e) => {
  e.preventDefault();
  const submenu = e.target.nextElementSibling;
  submenu.style.display = submenu.style.display === 'block' ? 'none' : 'block';
});

// Form Validation with XSS Prevention
document.getElementById('userForm').addEventListener('submit', (e) => {
  e.preventDefault();

  const username = document.getElementById('username').value.trim();
  const email = document.getElementById('email').value.trim();

  // Simple validation
  if (!username || !email) {
    alert('All fields are required!');
    return;
  }

  // XSS Prevention
  const sanitizedUsername = username.replace(/</g, '&lt;').replace(/>/g, '&gt;');
  const sanitizedEmail = email.replace(/</g, '&lt;').replace(/>/g, '&gt;');

  // Dynamic Content Update
  const dynamicContent = document.getElementById('dynamicContent');
  dynamicContent.innerHTML = `
    <p><strong>Thank you, ${sanitizedUsername}!</strong></p>
    <p>We have received your email: ${sanitizedEmail}</p>
  `;
});

// Dynamic Content Update Example
setTimeout(() => {
  const dynamicContent = document.getElementById('dynamicContent');
  dynamicContent.innerHTML = <p>New content loaded dynamically!</p>;
}, 5000);
